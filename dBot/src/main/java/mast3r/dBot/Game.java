package mast3r.dBot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Game {
	public void Return(MessageReceivedEvent e) {
		e.getChannel().sendMessage("return").queue();
	}

	public MessageEmbed run(MessageReceivedEvent e) {
		// TODO Auto-generated method stub
		EmbedBuilder embed = new EmbedBuilder();
		embed.addField("", ":white_large_square::white_large_square::white_large_square:" + '\n' + ":white_large_square::white_large_square::white_large_square:" + '\n' + ":white_large_square::white_large_square::white_large_square:", false);
		
		return embed.build();
	}

	public void move(String string) {
		// TODO Auto-generated method stub
		
	}
}