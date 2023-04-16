package com.staminaadvisor;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Units;

@ConfigGroup("example")
public interface StaminaAdvisorConfig extends Config
{
	@ConfigItem(
			keyName = "shouldNotify",
			name = "Notify when stamina effect expires",
			description = "Sends a notification once the stamina potion needs to be drunk"
	)

	default boolean shouldNotify()
	{
		return true;
	}

	@ConfigItem(
			keyName = "staminaTimeout",
			name = "Timeout Stamina Box",
			description = "The duration of time before the stamina box disappears."
	)
	@Units(Units.MINUTES)
	default int staminaTimeout()
	{
		return 3;
	}

	@ConfigItem(
			keyName = "shouldFlash",
			name = "Flash the Reminder Box",
			description = "Makes the reminder box flash."
	)
	default boolean shouldFlash() { return false; }
}
