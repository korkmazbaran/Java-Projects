package Helper;

import javax.swing.JOptionPane;

public class Helper {

	public static void showMsg(String str) {
		String msg;

		switch (str) {
		case "fill":
			msg = "please fill in all fields. ";
			break;
		case "success":
			msg = "Successful process";
			break;

		default:
			msg = str;
			break;
		}

		JOptionPane.showMessageDialog(null, msg, "Mesaj", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static boolean confirm(String str) {
		String msg;
		switch (str) {
		case "sure": {
			msg = "Do you want to do this process ? ";
			break;
		}
		default:
			msg=str;
			break;
		}
		int res = JOptionPane.showConfirmDialog(null, msg,"Warning !", JOptionPane.YES_NO_OPTION);
		if (res == 0 ) {
			return true;
		}
		else {
			return false;
		}
	}

}
