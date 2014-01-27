package net.pferdimanzug.hearthstone.analyzer.game.cards.concrete.priest;

import net.pferdimanzug.hearthstone.analyzer.game.GameContext;
import net.pferdimanzug.hearthstone.analyzer.game.Player;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Card;
import net.pferdimanzug.hearthstone.analyzer.game.cards.Rarity;
import net.pferdimanzug.hearthstone.analyzer.game.cards.SpellCard;
import net.pferdimanzug.hearthstone.analyzer.game.entities.Entity;
import net.pferdimanzug.hearthstone.analyzer.game.entities.heroes.HeroClass;
import net.pferdimanzug.hearthstone.analyzer.game.spells.Spell;
import net.pferdimanzug.hearthstone.analyzer.game.targeting.TargetSelection;

public class MindVision extends SpellCard {
	

	private class CopyCardSpell extends Spell {

		@Override
		protected void onCast(GameContext context, Player player, Entity target) {
			Card randomCard = context.getOpponent(player).getHand().getRandom();
			if (randomCard == null) {
				return;
			}
			Card clone = randomCard.clone();
			player.getHand().add(clone);
		}
		
	}
	
	public MindVision() {
		super("Mind Vision", Rarity.FREE, HeroClass.PRIEST, 1);
		setSpell(new CopyCardSpell());
		setTargetRequirement(TargetSelection.NONE);
	}

}