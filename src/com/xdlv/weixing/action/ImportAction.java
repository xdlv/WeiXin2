package com.xdlv.weixing.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xdlv.fw.FwException;
import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.Dzlist;
import com.xdlv.weixing.bean.ImportDzRecord;
import com.xdlv.weixing.bean.UserCompany;
import com.xdlv.weixing.service.UserSerivce;

public class ImportAction extends BaseAction {
    File excel;
    String excelFileName;
    String excelContentType;

    int year;
    int month;

    UserSerivce userSerivce;

    public String importTelephone() throws Exception {
        Workbook wb = parseFile(excel);
        List<UserCompany> userCompanyList = new ArrayList<UserCompany>();
        Sheet sheet = wb.getSheetAt(0);
        Cell cell;
        Row row;
        String value;
        for (int i = 1; ; i++) {
            row = sheet.getRow(i);
            if (row == null || StringUtils.isBlank(getCellValue(row.getCell(0)))) {
                break;
            }
            UserCompany userCompany = new UserCompany();
            userCompanyList.add(userCompany);
            for (int j = 1; j < 11; j++) {
                cell = row.getCell(j);
                value = getCellValue(cell);
                if (StringUtils.isEmpty(value)) {
                    continue;
                }
                switch (j) {
                    case 1:
                        userCompany.setCode(value);
                        break;
                    case 2:
                        userCompany.setCompanyName(value);
                        break;
                    case 3:
                        userCompany.setArea(value);
                        break;
                    case 4:
                        userCompany.setBusiness("是".equals(value) ? "Y" : "N");
                        break;
                    case 5:
                        userCompany.setWxContractName1(value);
                        break;
                    case 6:
                        userCompany.setWxContractPhone1(value);
                        break;
                    case 7:
                        userCompany.setWxContractName2(value);
                        break;
                    case 8:
                        userCompany.setWxContractPhone2(value);
                        break;
                    case 9:
                        userCompany.setManagerName(value);
                        break;
                    case 10:
                        userCompany.setRemarkContent(value);
                        break;
                }
            }
        }
        userSerivce.batchSaveUserCompany(userCompanyList);
        setRequestAttribute(
                "msg", String.format("成功解析%d条数据", userCompanyList.size()));
        return FINISH;
    }

    public String importDzlist() throws Exception {
        ImportDzRecord importDzRecord = userSerivce.getImportDzRecordByYearAndMonth(year, month);
        if (importDzRecord != null) {
            throw new FwException(String.format("%d年%d月的记录己存在，无法再次导入。", year, month));
        }
        Workbook wb = parseFile(excel);
        Map<String, Dzlist> dzlistMap = new HashMap<String, Dzlist>();
        Sheet sheet = wb.getSheetAt(0);
        Row row;
        String code, userName, subject, dfScope;
        Dzlist dzlist;
        float all;
        for (int i = 1; ; i++) {
            row = sheet.getRow(i);
            if (row == null) {
                break;
            }

            code = getCellValue(row.getCell(1));
            if (StringUtils.isBlank(code)) {
                continue;
            }
            userName = getCellValue(row.getCell(2));
            if (StringUtils.isBlank(userName)) {
                continue;
            }
            subject = getCellValue(row.getCell(3));
            all = (float) row.getCell(5).getNumericCellValue();
            dfScope = getCellValue(row.getCell(6));

            dzlist = dzlistMap.get(code + dfScope);
            if (dzlist == null) {
                dzlist = new Dzlist();
                dzlist.setYear(year);
                dzlist.setMonth(month);
                dzlist.setUserid(code);
                dzlist.setUsername(userName);
                dzlistMap.put(code + dfScope, dzlist);
            }
            switch (Integer.parseInt(subject)) {
                case 1131020100:
                    dzlist.setZdxsk1(all);
                    break;
                case 1131020200:
                    dzlist.setZdfwk1(all);
                    break;
                case 1131020400:
                    dzlist.setYsdsk1(all);
                    break;
                case 1131020601:
                    dzlist.setJb1(all);
                    break;
                case 1131020602:
                    dzlist.setFl1(all);
                    break;
                case 2131020100:
                    dzlist.setZdxsk2(all);
                    break;
                case 2131020200:
                    dzlist.setZdfwk2(all);
                    break;
                case 2131020401:
                    dzlist.setJb2(all);
                    break;
                case 2131020402:
                    dzlist.setFl2(all);
                    break;
                case 2131030000:
                    dzlist.setQtyfdk2(all);
                    break;
            }
        }

        userSerivce.batchSaveDzlists(dzlistMap.values());
        userSerivce.saveImportDzRecord(new ImportDzRecord(year, month));
        return FINISH;
    }

    private String getCellValue(Cell cell) {
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return cell.getStringCellValue();
        }
    }

    private static Workbook parseFile(File excelFile) throws Exception {
        Workbook book = null;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(excelFile);
            book = new HSSFWorkbook(inputStream);
        } catch (Exception ex) {
            book = new XSSFWorkbook(excelFile);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return book;
    }

    public File getExcel() {
        return excel;
    }

    public void setExcel(File excel) {
        this.excel = excel;
    }

    public String getExcelFileName() {
        return excelFileName;
    }

    public void setExcelFileName(String excelFileName) {
        this.excelFileName = excelFileName;
    }

    public String getExcelContentType() {
        return excelContentType;
    }

    public void setExcelContentType(String excelContentType) {
        this.excelContentType = excelContentType;
    }

    public void setUserSerivce(UserSerivce userSerivce) {
        this.userSerivce = userSerivce;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
