package com.kingword.common;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;


/**
 * �ַ����İ����࣬�ṩ��̬������������ʵ������
 * 
 * @author davin
 * 
 */
public class StrUtils {
	/**
	 * ��ֹʵ����
	 */
	private StrUtils() {
	}

	/**
	 * ����url
	 * 
	 * urlΪnull����null��urlΪ�մ�����http://��https://��ͷ�������http://�������������ԭ������
	 * 
	 * @param url
	 * @return
	 */
	public static String handelUrl(String url) {
		if (url == null) {
			return null;
		}
		url = url.trim();
		if (url.equals("") || url.startsWith("http://")
				|| url.startsWith("https://")) {
			return url;
		} else {
			return "http://" + url.trim();
		}
	}

	/**
	 * �ָ��ȥ���ո�
	 * 
	 * @param str
	 *            ���ָ��ַ���
	 * @param sep
	 *            �ָ��
	 * @param sep2
	 *            �ڶ����ָ���
	 * @return ���strΪ�գ��򷵻�null��
	 */
	public static String[] splitAndTrim(String str, String sep, String sep2) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		if (!StringUtils.isBlank(sep2)) {
			str = StringUtils.replace(str, sep2, sep);
		}
		String[] arr = StringUtils.split(str, sep);
		// trim
		for (int i = 0, len = arr.length; i < len; i++) {
			arr[i] = arr[i].trim();
		}
		return arr;
	}

	/**
	 * �ı�תhtml
	 * 
	 * @param txt
	 * @return
	 */
	public static String txt2htm(String txt) {
		if (StringUtils.isBlank(txt)) {
			return txt;
		}
		StringBuilder sb = new StringBuilder((int) (txt.length() * 1.2));
		char c;
		boolean doub = false;
		for (int i = 0; i < txt.length(); i++) {
			c = txt.charAt(i);
			if (c == ' ') {
				if (doub) {
					sb.append(' ');
					doub = false;
				} else {
					sb.append("&nbsp;");
					doub = true;
				}
			} else {
				doub = false;
				switch (c) {
				case '&':
					sb.append("&amp;");
					break;
				case '<':
					sb.append("&lt;");
					break;
				case '>':
					sb.append("&gt;");
					break;
				case '"':
					sb.append("&quot;");
					break;
				case '\n':
					sb.append("<br/>");
					break;
				default:
					sb.append(c);
					break;
				}
			}
		}
		return sb.toString();
	}

	/**
	 * �����ı�����������˼��У������ı������"..."
	 * 
	 * @param s
	 *            ���ж���
	 * @param len
	 *            ����С��256����Ϊһ���ַ�������256����Ϊ�����ַ���
	 * @return
	 */
	public static String textCut(String s, int len, String append) {
		if (s == null) {
			return null;
		}
		int slen = s.length();
		if (slen <= len) {
			return s;
		}
		// �����������ȫ��Ӣ�ģ�
		int maxCount = len * 2;
		int count = 0;
		int i = 0;
		for (; count < maxCount && i < slen; i++) {
			if (s.codePointAt(i) < 256) {
				count++;
			} else {
				count += 2;
			}
		}
		if (i < slen) {
			if (count > maxCount) {
				i--;
			}
			if (!StringUtils.isBlank(append)) {
				if (s.codePointAt(i - 1) < 256) {
					i -= 2;
				} else {
					i--;
				}
				return s.substring(0, i) + append;
			} else {
				return s.substring(0, i);
			}
		} else {
			return s;
		}
	}

	/**
	 * ����ַ������Ƿ�������������ַ��������������ַ�������ʹ��ͨ���'*'��
	 * 
	 * @param str
	 * @param search
	 * @return
	 */
	public static boolean contains(String str, String search) {
		if (StringUtils.isBlank(str) || StringUtils.isBlank(search)) {
			return false;
		}
		String reg = StringUtils.replace(search, "*", ".*");
		Pattern p = Pattern.compile(reg);
		return p.matcher(str).matches();
	}
	/*ͳ�����ı��г��ֵĴ���*/
	public static int countstringoftext(String text,String sub){
        int count =0, start =0;
        while((start=text.indexOf(sub,start))>=0){
            start += sub.length();
            count ++;
        }
        return count;
    }
}
