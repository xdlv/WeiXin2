package com.xdlv.weixing.action;

import com.xdlv.fw.FwException;
import com.xdlv.fw.FwUtil;
import com.xdlv.fw.I18n;
import com.xdlv.fw.action.BaseAction;
import com.xdlv.weixing.bean.Dzlist;
import com.xdlv.weixing.service.UserSerivce;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by xd on 2015/10/31.
 */
public class DzlistAction extends BaseAction{

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
    List<Dzlist> dzlists;
    UserSerivce userSerivce;

    Dzlist dzlist = new Dzlist();
    private InputStream excelFile;
    private String fileName;
    public String obtainDzlists()throws Exception{
        if (dzlist != null && StringUtils.isNotBlank(dzlist.getUsername())){
            dzlist.setUsername(URLDecoder.decode(dzlist.getUsername(), FwUtil.UTF8));
        }
        total = userSerivce.getDzListCount(dzlist);
        dzlists = userSerivce.getAllDzlists(dzlist,start, start + limit);
        return SUCCESS;
    }

    public String downLoadDzlists() throws Exception{
        obtainDzlists();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet1");
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        String[] titles = I18n.getI18n("export_dz_titles").split(" ");
        HSSFCell cell;
        int COUNT = 17;
        for (int i=0;i<COUNT;i++){
            cell = row.createCell(i);
            cell.setCellValue(titles[i]);
        }
        Dzlist tmp;
        for (int i=0;dzlists != null && i<dzlists.size(); i++){
            tmp = dzlists.get(i);
            row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(tmp.getYear());
            row.createCell(1).setCellValue(tmp.getMonth());
            row.createCell(2).setCellValue(sdf.format(tmp.getImpdate()));
            row.createCell(3).setCellValue(tmp.getUserid());
            row.createCell(4).setCellValue(tmp.getUsername());
            row.createCell(5).setCellValue(tmp.getIsok());
            row.createCell(6).setCellValue(tmp.getQmye());
            row.createCell(7).setCellValue(tmp.getZdxsk1());
            row.createCell(8).setCellValue(tmp.getYsdsk1());
            row.createCell(9).setCellValue(tmp.getZdfwk1());
            row.createCell(10).setCellValue(tmp.getJb1());
            row.createCell(11).setCellValue(tmp.getFl1());
            row.createCell(12).setCellValue(tmp.getZdxsk2());
            row.createCell(13).setCellValue(tmp.getJb2());
            row.createCell(14).setCellValue(tmp.getFl2());
            row.createCell(15).setCellValue(tmp.getZdfwk2());
            row.createCell(16).setCellValue(tmp.getQtyfdk2());
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        wb.write(output);
        excelFile = new ByteArrayInputStream(output.toByteArray());
        output.flush();
        output.close();
        wb.close();
        fileName = "对账记录";
        return SUCCESS;
    }

    public InputStream getExcelFile() {
        return excelFile;
    }

    public String getFileName() throws Exception {
        return fileName;
    }

    public void setUserSerivce(UserSerivce userSerivce) {
        this.userSerivce = userSerivce;
    }

    public void setDzlists(List<Dzlist> dzlists) {
        this.dzlists = dzlists;
    }

    public List<Dzlist> getDzlists() {
        return dzlists;
    }

    public Dzlist getDzlist() {
        return dzlist;
    }

    public void setDzlist(Dzlist dzlist) {
        this.dzlist = dzlist;
    }

}
