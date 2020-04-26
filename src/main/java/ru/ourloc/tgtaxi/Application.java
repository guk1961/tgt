package ru.ourloc.tgtaxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import ru.ourloc.tgt.TgTaxiBot;

@SpringBootApplication
//@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
/*        
		System.getProperties().put("proxiSet", "true");
		System.getProperties().put("socksProxyHost", "127.0.0.1");
		System.getProperties().put("socksProxyPort", "9150");

		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

		try {
			telegramBotsApi.registerBot(new TgTaxiBot());
		} catch (Exception e) {
				e.printStackTrace();
		}
		System.out.println("tgtaxibot starting...");
*/
		
		
		/////////////////////////PROXI/////////////////////////
//		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
//
//		// Set up Http proxy
//		DefaultBotOptions botOptions = ApiContext.getInstance(DefaultBotOptions.class);
//		botOptions.setProxyHost("127.0.0.1");
//		botOptions.setProxyPort(9150);
//		// Select proxy type: [HTTP|SOCKS4|SOCKS5] (default: NO_PROXY)
//		botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
//
//		try {
//		    telegramBotsApi.registerBot(new TgTaxiBot(BotConfig.BOT_TOKEN, BotConfig.BOT_USERNAME, botOptions));
//		} catch (TelegramApiRequestException e) {
//
//		}
		//////////////////////////////////////////////////////
		
		

    }
}
