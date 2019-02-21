package com.yx1030.idea_springboot_mybatis_jsp_mysql_user.utils;

public class BaseModel implements java.io.Serializable {

    /**
     * sdf
     */
    private static final long serialVersionUID = 4994848560358696240L;
    // ��ѯ���ݿ��ȡ�ܸ���
    private int totalCount;
    // �ܵ�ҳ��
    private int pageCount;
    // ÿҳ������
    private int pageSize = 2;
    // ��ǰҳ��
    private int pageIndex = 1;
    // ��ʼλ��
    private int startPos;
    // ����λ��
    private int endPos;
    // ��ʼʱ��
    private String beginTime;
    // ����ʱ��
    private String endTime;
    //�ؼ���
    private String keyword;

    private String pageStr;        //����ҳ����ʾ�ĵײ���ҳ��������ϸ����getPageStr();


    public void calculatePage() {
        // ��ȡ��ҳ��
        if (totalCount % pageSize == 0) {
            pageCount = totalCount / pageSize;
        } else {
            pageCount = totalCount / pageSize + 1;
        }
        // ���㿪ʼ��¼�Լ�������¼
        // pageindex == 1 �� startPos = 0��endPos = 3
        // pageindex == 1 �� startPos = 3��endPos = 6
        startPos = (pageIndex - 1) * pageSize;
        endPos = pageIndex * pageSize;
    }


    public int getTotalCount() {
        return totalCount;
    }


    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }


    public int getPageCount() {
        return pageCount;
    }


    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }


    public int getPageSize() {
        return pageSize;
    }


    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public int getPageIndex() {
        return pageIndex;
    }


    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }


    public int getStartPos() {
        return startPos;
    }


    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }


    public int getEndPos() {
        return endPos;
    }


    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }


    public String getBeginTime() {
        return beginTime;
    }


    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }


    public String getEndTime() {
        return endTime;
    }


    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getKeyword() {
        return keyword;
    }


    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getPageStr() {
        StringBuffer sb = new StringBuffer();
        if (totalCount > 0) {
            if (pageIndex == 1) {
                sb.append("	<a>��<font color=red>" + totalCount + "</font>��</a>");
                sb.append("	<input type=\"number\" style=\"width:55px;\" value=\"\" id=\"toGoPage\"  placeholder=\"ҳ��\"/>");
                sb.append("	<a onclick=\"toTZ();\"  class=\"btn btn-mini btn-success\">��ת</a>");
                sb.append("	<a>��ҳ</a>\n");
                sb.append("	<a>��ҳ</a>\n");
            } else {
                sb.append("	<a>��<font color=red>" + totalCount + "</font>��</a>\n");
                sb.append("	<input type=\"number\" style=\"width:55px;\" value=\"\" id=\"toGoPage\" style=\"width:50px;text-align:center;float:left;margin-top:4px;\" placeholder=\"ҳ��\"/>\n");
                sb.append("	<a onclick=\"toTZ();\"  class=\"btn btn-mini btn-success\">��ת</a>\n");
                sb.append("	<a onclick=\"nextPage(1)\">��ҳ</a>\n");
                sb.append("	<a onclick=\"nextPage(" + (pageIndex - 1) + ")\">��ҳ</a>\n");
            }
            int startTag = 1;
            if (pageIndex > pageSize) {
                startTag = pageIndex - 1;
            }
            int endTag = startTag + pageSize - 1;
            for (int i = startTag; i <= pageCount && i <= endTag; i++) {
                if (pageIndex == i)
                    sb.append("<a><font color='#808080'>" + i + "</font></a>\n");
                else
                    sb.append("	<a onclick=\"nextPage(" + i + ")\">" + i + "</a>\n");
            }
            if (pageIndex == pageCount) {
                sb.append("	<a>��ҳ</a>\n");
                sb.append("	<a>βҳ</a>\n");
            } else {
                sb.append("	<a onclick=\"nextPage(" + (pageIndex + 1) + ")\">��ҳ</a>\n");
                sb.append("	<a onclick=\"nextPage(" + pageCount + ")\">βҳ</a>\n");
            }
            sb.append("	<a>��" + pageIndex + "ҳ</a>\n");
            sb.append("	<a>��" + pageCount + "ҳ</a>\n");


            sb.append("	<select title='��ʾ����' style=\"width:55px;\" onchange=\"changeCount(this.value)\">\n");

            for (int i = 1; i < 10; i++) {
                int cn = 10 * i;
                if (pageSize == cn) {
                    sb.append("	<option value='" + cn + "' selected>" + cn + "</option>\n");
                } else {
                    sb.append("	<option value='" + cn + "'>" + cn + "</option>\n");
                }
            }
            sb.append("	</select>\n");
            sb.append("	\n");


            sb.append("<script type=\"text/javascript\">\n");

            //��ҳ����
            sb.append("function nextPage(page){");   //ÿ�����ҳ���¼� ������js���� ����
            //sb.append(" top.jzts();");
            sb.append("	if(true && document.forms[0]){\n");   //�ж��Ƿ���һ��form
            sb.append("		var url = document.forms[0].getAttribute(\"action\");\n"); //��ȡaction����
            sb.append("		if(url.indexOf('?')>-1){url += \"&pageIndex=\";}\n");
            sb.append("		else{url += \"?pageIndex=\";}\n");
            sb.append("		url = url + page + \"&pageSize=" + pageSize + "\";\n");
            sb.append("		document.forms[0].action = url;\n");  //�õ������ύ·��
            sb.append("		document.forms[0].submit();\n");   //���ύ
            sb.append("	}else{\n");
            sb.append("		var url = document.location+'';\n");
            sb.append("		if(url.indexOf('?')>-1){\n");
            sb.append("			if(url.indexOf('pageIndex')>-1){\n");
            sb.append("				var reg = /pageIndex=\\d*/g;\n");
            sb.append("				url = url.replace(reg,'pageIndex=');\n");
            sb.append("			}else{\n");
            sb.append("				url += \"&pageIndex=\";\n");
            sb.append("			}\n");
            sb.append("		}else{url += \"?pageIndex=\";}\n");
            sb.append("		url = url + page + \"&pageSize=" + pageSize + "\";\n");
            sb.append("		document.location = url;\n");
            sb.append("	}\n");
            sb.append("}\n");

            //����ÿҳ��ʾ����
            sb.append("function changeCount(value){");
            //sb.append(" top.jzts();");
            sb.append("	if(true && document.forms[0]){\n");
            sb.append("		var url = document.forms[0].getAttribute(\"action\");\n");
            sb.append("		if(url.indexOf('?')>-1){url += \"&pageIndex=\";}\n");
            sb.append("		else{url += \"?pageIndex=\";}\n");
            sb.append("		url = url + \"1&pageSize=\"+value;\n");
            sb.append("		document.forms[0].action = url;\n");
            sb.append("		document.forms[0].submit();\n");
            sb.append("	}else{\n");
            sb.append("		var url = document.location+'';\n");
            sb.append("		if(url.indexOf('?')>-1){\n");
            sb.append("			if(url.indexOf('pageIndex')>-1){\n");
            sb.append("				var reg = /pageIndex=\\d*/g;\n");
            sb.append("				url = url.replace(reg,'pageIndex=');\n");
            sb.append("			}else{\n");
            sb.append("				url += \"1&pageIndex=\";\n");
            sb.append("			}\n");
            sb.append("		}else{url += \"?pageIndex=\";}\n");
            sb.append("		url = url + \"&pageSize=\"+value;\n");
            sb.append("		document.location = url;\n");
            sb.append("	}\n");
            sb.append("}\n");

            //��ת����
            sb.append("function toTZ(){");
            sb.append("var toPaggeVlue = document.getElementById(\"toGoPage\").value;");
            sb.append("if(toPaggeVlue == ''){document.getElementById(\"toGoPage\").value=1;return;}");
            sb.append("if(isNaN(Number(toPaggeVlue))){document.getElementById(\"toGoPage\").value=1;return;}");
            sb.append("nextPage(toPaggeVlue);");
            sb.append("}\n");
            sb.append("</script>\n");
        }
        pageStr = sb.toString();
        return pageStr;
    }

}
