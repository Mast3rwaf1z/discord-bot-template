package mast3r.dBot;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
	final private char prefix = '-';
	Boolean running = false;
	MessageEmbed embed;
	
@Override
public void onMessageReceived(MessageReceivedEvent event) {
	Long authorID = event.getAuthor().getIdLong();
	Message message = event.getMessage();
	String content = event.getMessage().getContentRaw();
	TextChannel channel = event.getTextChannel();
	Game game = new Game();
	if(event.getChannel().getName().equalsIgnoreCase("bot") && !event.getAuthor().isBot()) {
		
		
		System.out.println("message Received!");
		System.out.println(message.getContentRaw());
		switch(content) {
			case prefix + "message":
				channel.sendMessage("message received!").queue();
				break;
			case prefix + "react":
				message.addReaction("U+1F44D").queue();
				break;
			case prefix + "debug":
				System.out.println("debug");
				break;
			case prefix + "launch":
				System.out.println("launching game");
				channel.sendMessage("launching game :ok_hand:").queue();
				running = true;
				break;
		}
		if(running && !event.getAuthor().isBot()) {
			//game.Return(event);
			System.out.println("game running");
			embed = game.run(event);
			channel.sendMessage(embed).queue();
			switch(content) {
			case "w":
				game.move("up");
				break;
			case "a":
				game.move("left");
				break;
			case "s":
				game.move("down");
				break;
			case "d":
				game.move("right");
				break;
			}
		}
		if(running) {
			System.out.println("reactions");
			message.addReaction("←").queue();
			message.addReaction("→").queue();
			message.addReaction("↑").queue();
			message.addReaction("↓").queue();
		}
	}
	//hard crash command
	if(channel.getName().equalsIgnoreCase("bot") && authorID.equals(214752462769356802L) && message.getContentRaw().equalsIgnoreCase(prefix + "crash")) {
		System.exit(0);
	}
}
}