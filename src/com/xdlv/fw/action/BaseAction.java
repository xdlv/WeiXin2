package com.xdlv.fw.action;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.opensymphony.xwork2.ActionSupport;
import com.xdlv.fw.FwUtil;
import com.xdlv.weixing.bean.ReceiveXmlEntity;

public abstract class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public final static String FINISH = "finish"
			, LOGIN = "login", XML = "xml",EXCEL = "excel";
	private static Pattern SPLITE_PATTERN = Pattern.compile(",");

	public final static String USER_NAME = "";
	protected Logger log = Logger.getLogger(getClass());

	protected int start = 0;
	protected int limit = 0;

	protected int total = 0;
	protected int page = 0;
	protected long _dc;

	protected boolean success = true;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void set_dc(long _dc) {
		this._dc = _dc;
	}

	/*
	 * public int currentUserId(){ return
	 * (Integer)ServletActionContext.getRequest().getSession().getAttribute(
	 * "userId"); }
	 */

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	protected int[] parseStatus(String st) {
		String[] status = SPLITE_PATTERN.split(st, 0);
		int[] ret = new int[status.length];
		for (int i = 0; i < status.length; i++) {
			ret[i] = Integer.parseInt(status[i]);
		}
		return ret;
	}

	protected ReceiveXmlEntity getMsgEntity() {
		ReceiveXmlEntity msg = new ReceiveXmlEntity();
		try {
			Document document = new SAXBuilder().build(
					ServletActionContext.getRequest().getInputStream(), FwUtil.UTF8);
			Element root = document.getRootElement();
			Element child;
			for (Object obj : root.getChildren()) {
				child = (Element) obj;
				try{
					ReceiveXmlEntity.class.getMethod("set" + child.getName()
							, String.class).invoke(msg, child.getText());
				}catch (Exception e){
					log.error("can not invoke:set" + child.getName(),e);
					continue;
				}

			}
		} catch (Exception e) {
			log.error("exception occurs at error xml:", e);
		}
		return msg;
	}

	protected void setRequestAttribute(String key, String value){
        ServletActionContext.getRequest().setAttribute(key,value);
    }
	
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		ReceiveXmlEntity msg = new ReceiveXmlEntity();
		BeanUtils.setProperty(msg, "toUserName", "23");
		System.out.println(msg.getToUserName());
	}
}