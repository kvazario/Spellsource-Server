package net.demilich.metastone.game.cards.concrete.goblinsvsgnomes.druid;

import net.demilich.metastone.game.actions.Battlecry;
import net.demilich.metastone.game.cards.ChooseBattlecryCard;
import net.demilich.metastone.game.cards.Rarity;
import net.demilich.metastone.game.entities.heroes.HeroClass;
import net.demilich.metastone.game.entities.minions.Minion;
import net.demilich.metastone.game.spells.DrawCardSpell;
import net.demilich.metastone.game.spells.GainManaSpell;
import net.demilich.metastone.game.spells.MetaSpell;
import net.demilich.metastone.game.spells.ModifyMaxManaSpell;
import net.demilich.metastone.game.spells.TargetPlayer;
import net.demilich.metastone.game.spells.desc.SpellDesc;

public class GroveTender extends ChooseBattlecryCard {

	public GroveTender() {
		super("Grove Tender", 2, 4, Rarity.RARE, HeroClass.DRUID, 3);
		setDescription("Choose One - Give each player a Mana Crystal; or Each player draws a card.");
	}

	@Override
	protected String getAction1Suffix() {
		return "Mana Crystal";
	}

	@Override
	protected String getAction2Suffix() {
		return "Draw";
	}

	@Override
	protected Battlecry getBattlecry1() {
		SpellDesc spell = MetaSpell.create(ModifyMaxManaSpell.create(+1, TargetPlayer.BOTH), GainManaSpell.create(1));
		Battlecry battlecry = Battlecry.createBattlecry(spell);
		return battlecry;
	}

	@Override
	protected Battlecry getBattlecry2() {
		Battlecry battlecry = Battlecry.createBattlecry(DrawCardSpell.create(1, TargetPlayer.BOTH));
		return battlecry;
	}

	@Override
	public int getTypeId() {
		return 479;
	}



	@Override
	public Minion summon() {
		Minion groveTender = createMinion();
		return groveTender;
	}
}