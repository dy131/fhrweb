package com.fhrweb.util;

public class LotteryUtil {


	private static String weekName[] = { "ä¸?", "äº?", "ä¸?", "å›?", "äº?", "å…?", "æ—?" };

	public static String getWeekNo(int no) {
		int w = ((no / 1000) + 6) % 7;
		String s = "000" + no;
		return "å‘?" + weekName[w];
	}

	public static String getBallHtml3(String bonusCode, String lotId) {
		StringBuffer sb = new StringBuffer("");
		if (bonusCode != null && bonusCode.length() > 0) {
			if ("4d".equals(lotId) && bonusCode.indexOf("-") > 0) {
				String bs[] = bonusCode.split("-");
				bonusCode = bs[bs.length - 1];
			}
			String ccc[] = bonusCode.split("#");
			int n = 0;
			for (int i = 0; i < ccc.length; i++) {
				if (i == 1 && "601".equals(lotId)) {
					try {
						sb
								.append("<img  style=\"margin-left:4px;\" src=\"http://pic.gooooal.com/userCenter/images/ball_sx_"
										+ ccc[i] + ".gif\">");
					} catch (NumberFormatException e) {
						System.out.println(e.getMessage());
					}
				} else {
					String cc[] = ccc[i].split(",");
					for (String c : cc) {
						sb
								.append("<img style=\"margin-left:4px;\" src=\"http://pic.gooooal.com/userCenter/images/ball_"
										+ (i == 1 ? "b" : "r")
										+ "_"
										+ c
										+ ".gif\">");
					}
				}
			}
		}
		return sb.toString();
	}


}
