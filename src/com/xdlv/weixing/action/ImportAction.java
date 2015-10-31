package com.xdlv.weixing.action;

import com.opensymphony.xwork2.ActionContext;
import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.UserCompany;
import com.xdlv.weixing.service.UserSerivce;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ImportAction extends BaseAction{
    File excel;
    String excelFileName;
    String excelContentType;

    UserSerivce userSerivce;

    public String importTelephone() throws Exception{
        Workbook wb = parseFile(excel);
        List<UserCompany> userCompanyList = new ArrayList<UserCompany>();
        Sheet sheet = wb.getSheetAt(0);
        Cell cell;
        Row row;
        String value;
        for (int i= 1; ; i++ ){
            row = sheet.getRow(i);
            if (row == null || StringUtils.isBlank(getCellValue(row.getCell(0)))){
                break;
            }
            UserCompany userCompany = new UserCompany();
            userCompanyList.add(userCompany);
            for (int j=1;j<11;j++){
                cell = row.getCell(j);
                value = getCellValue(cell);
                if (StringUtils.isEmpty(value)){
                    continue;
                }
                switch (j){
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
                    case 5 :
                        userCompany.setWxContractName1(value);
                        break;
                    case 6 :
                        userCompany.setWxContractPhone1(value);
                        break;
                    case 7:
                        userCompany.setWxContractName2(value);
                        break;
                    case 8 :
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
                "msg",String.format("成功解析%d条数据",userCompanyList.size()));
        return FINISH;
    }

    private String getCellValue(Cell cell){
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
            return String.valueOf(cell.getNumericCellValue());
        } else {
            return cell.getStringCellValue();
        }
    }

    private Workbook parseFile(File excelFile) throws Exception{
        Workbook book = null;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(excelFile);
            book = new HSSFWorkbook(inputStream);
        } catch (Exception ex) {
            book = new XSSFWorkbook(excelFile);
        } finally {
            if (inputStream != null){
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
}
