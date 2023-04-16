package com.staminaadvisor;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.client.Notifier;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Stamina Advisor"
)
public class StaminaAdvisorPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private StaminaAdvisorConfig config;

	@Inject
	private ClientThread clientThread;

	@Inject
	private Notifier notifier;

	@Inject
	private SpriteManager spriteManager;

	@Inject
	private StaminaAdvisorOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Override
	protected void startUp() throws Exception
	{
		log.info("Example started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("Example stopped!");
		overlayManager.remove(overlay);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (client.getVar(Varbits.STAMINA_EFFECT) > 0) {
			overlayManager.add(overlay);
		// Player is affected by a stamina potion effect
		// Add your desired code here
	} else {
			overlayManager.remove(overlay);
		// Player is not affected by a stamina potion effect
		// Add your desired code here
	}
	}

	@Provides
	StaminaAdvisorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(StaminaAdvisorConfig.class);
	}
}
