package com.staminaadvisor;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class StaminaAdvisorPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(StaminaAdvisorPlugin.class);
		RuneLite.main(args);
	}
}