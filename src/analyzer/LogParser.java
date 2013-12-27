package analyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Log;

public class LogParser {
//182.129.215.39 hxydbd.duapp.com [2013-12-16 18:10:44] 200 1663 1377 0 "GET /wp-content/themes/medicine/images/socials/linkedin.png HTTP/1.1" "http://hxydbd.duapp.com/wp-admin/widgets.php" "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36" pgv_pvi=6691857464;
//182.129.215.39 hxydbd.duapp.com [2013-12-16 18:10:44] 404 1565 345 0 "GET /favicon.ico HTTP/1.1" "" "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36" pgv_pvi=6691857464;
//182.129.215.39 hxydbd.duapp.com [2013-12-16 18:10:43] 200 1953 30405 6 "GET /wp-admin/load-scripts.php?c=1&load%5B%5D=hoverIntent,common,admin-bar,jquery-ui-core,jquery-ui-widget,jquery-ui-mouse,jquery-ui-sortable,jquery-ui-draggable,jquery-ui-dr&load%5B%5D=oppable,admin-widgets,svg-painter,heartbeat,wp-auth-check&ver=3.8 HTTP/1.1" "http://hxydbd.duapp.com/wp-admin/widgets.php" "Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36" wordpress_c0dd095f28ad61e5555130441c3e836d=admin%7C1387360373%7C7964cb7a973ba4508f62c851d0e5212f;
//114.243.46.158 wekeepwalking.duapp.com [2013-12-16 22:37:27] 200 1234 6485 1220 "GET / HTTP/1.1" "" "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36" 
	
	public static Log getLog(String trim) {
		if (trim == null || trim.length() == 0) return null;
		Pattern pattern = Pattern.compile("(.*) (.*) \\[(.*)\\] (\\d+) (\\d+) (\\d+) (\\d+) \\\"(.*)\\\" \\\"(.*)\\\" \\\"(.*)\\\"(.*)?");
		String str = "182.129.215.39 hxydbd.duapp.com [2013-12-16 18:10:44] 404 1565 345 0 \"GET /favicon.ico HTTP/1.1\" \"\" \"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36\" pgv_pvi=6691857464;";
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.find());
		return null;
	}
	public static void main(String[] args) {
		//if (trim == null || trim.length() == 0) return null;
		Pattern pattern = Pattern.compile("(.*) (.*) \\[(.*)\\] (\\d+) (\\d+) (\\d+) (\\d+) \\\"(.*)\\\" \\\"(.*)\\\" \\\"(.*)\\\"(.*)?");
		String str = "182.129.215.39 hxydbd.duapp.com [2013-12-16 18:10:44] 404 1565 345 0 \"GET /favicon.ico HTTP/1.1\" \"\" \"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.93 Safari/537.36\" pgv_pvi=6691857464;";
		
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.find());
		System.out.println(matcher.groupCount());
		for (int i = 0; i< matcher.groupCount(); i++) System.out.println(matcher.group(i));
		
		//return null;
	}

}
