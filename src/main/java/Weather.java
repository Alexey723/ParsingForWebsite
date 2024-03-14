
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class Weather {

	static String urlString = "https://world-weather.ru/pogoda/russia/krasnodar/7days/";

	private static Document getPage() throws IOException, URISyntaxException {

		URL url = new URI(urlString).toURL();
		Document page = Jsoup.parse(url, 10000);
		return page;
	}

	public void parsing() throws IOException, URISyntaxException {
		Document page = getPage();
		var days = page.select("div[class=weather-short]");
		var city = page.select("h1").first();
		System.out.println(city.text());
		System.out.println();
		for (var day : days) {
			var date = day.select("div[class=dates short-d]");
			var dateRed = day.select("div[class=dates short-d red]");
			var nightsText = day.select("tr[class=night] td[class=weather-day]");
			var nightTemp = day.select("tr[class=night] td[class=weather-temperature]");
			var nightPressure = day.select("tr[class=night] td[class=weather-pressure]");
			var nightWind = day.select("tr[class=night] td[class=weather-wind]");
			var nightHumidity = day.select("tr[class=night] td[class=weather-humidity]");

			var morningText = day.select("tr[class=morning] td[class=weather-day]");
			var morningTemp = day.select("tr[class=morning] td[class=weather-temperature]");
			var morningPressure = day.select("tr[class=morning] td[class=weather-pressure]");
			var morningWind = day.select("tr[class=morning] td[class=weather-wind]");
			var morningHumidity = day.select("tr[class=morning] td[class=weather-humidity]");

			var dayText = day.select("tr[class=day] td[class=weather-day]");
			var dayTemp = day.select("tr[class=day] td[class=weather-temperature]");
			var dayPressure = day.select("tr[class=day] td[class=weather-pressure]");
			var dayWind = day.select("tr[class=day] td[class=weather-wind]");
			var dayHumidity = day.select("tr[class=day] td[class=weather-humidity]");

			var eveningText = day.select("tr[class=evening] td[class=weather-day]");
			var eveningTemp = day.select("tr[class=evening] td[class=weather-temperature]");
			var eveningPressure = day.select("tr[class=evening] td[class=weather-pressure]");
			var eveningWind = day.select("tr[class=evening] td[class=weather-wind]");
			var eveningHumidity = day.select("tr[class=evening] td[class=weather-humidity]");

			System.out.println(date.text() + dateRed.text());
			System.out.println("Время дня  Температура  Давление  Ветер   Влажность");
			System.out.println(
					"  "+nightsText.text()+"        "+nightTemp.text()+"        "+nightPressure.text()+"       "+nightWind.text()+"      "+nightHumidity.text());
			System.out.println(
					"  "+morningText.text()+"        "+morningTemp.text()+"        "+morningPressure.text()+"       "+morningWind.text()+"      "+morningHumidity.text());
			System.out.println(
					"  "+dayText.text()+"        "+dayTemp.text()+"       "+dayPressure.text()+"       "+dayWind.text()+"      "+dayHumidity.text());
			System.out.println(
					"  "+eveningText.text()+"       "+eveningTemp.text()+"        "+eveningPressure.text()+"       "+eveningWind.text()+"      "+eveningHumidity.text());
			System.out.println();
		}
	}

}