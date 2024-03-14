import java.util.Scanner;

import org.jsoup.Jsoup;

public class Html {
	String url;
	String text;
	StringBuilder protocol = new StringBuilder("http://");
	Scanner scan = new Scanner(System.in);

	public void parsing() {
		System.out.println("Please, enter website, which you wish to parsing: ");
		url = scan.nextLine();
		protocol.append(url);
		String site = protocol.toString();
		System.out.println("What part of website you wish parsing:  ");
		text = scan.nextLine();
		try {
			var document = Jsoup.connect(site).get();
			var titleElement = document.select(text);
			for (var element : titleElement) {
				System.out.println(element.text() + " - " + element.attr("href"));
			}
//			if(titleElement.is(some)) {
//				System.out.printf("Sorry, but %s is empty, please choose another part: ", text);
//				text = scan.nextLine();
//				titleElement = document.selectFirst(text);
//			}
//			InetAddress remoteAddress = InetAddress.getByName(site);
//			String remoteHostAddress = remoteAddress.getHostAddress();
//			System.out.println(remoteHostAddress);

		} catch (Exception e) {
			e.printStackTrace();
		}
		scan.close();
	}
}