package mast3r.dBot;
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;


public class Main {
	static String token = "";
	public static void main(String[] args) throws LoginException, InterruptedException {
		
		//build the JDA
		JDABuilder builder = JDABuilder.createDefault(token);
		builder.setStatus(OnlineStatus.ONLINE);
		builder.setActivity(Activity.playing("Epic gaming"));
		builder.addEventListeners(new Commands());
		JDA jda = builder.build();
		jda.awaitReady();
		System.out.println("JDA has finished building");
		
		while(jda.getStatus() != null) {
		}
	}
}
