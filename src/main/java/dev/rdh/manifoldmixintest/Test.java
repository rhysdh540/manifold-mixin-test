package dev.rdh.manifoldmixintest;

import dev.rdh.manifoldmixintest.mixin.MinecraftMixin;
import dev.rdh.manifoldmixintest.mixin.PlacementInfoAccessor;
import net.fabricmc.api.ModInitializer;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;

import com.mojang.logging.LogUtils;
import com.simibubi.create.content.trains.track.TrackPlacement.PlacementInfo;

import org.slf4j.Logger;

public class Test implements ModInitializer {
	Logger l = LogUtils.getLogger();
	@Override
	public void onInitialize() {
		minecraft();
		notMinecraft();
	}

	/**
	 * target: {@link Minecraft#lastTime}
	 */
	public void minecraft() {
		final Minecraft mc = Minecraft.getInstance();

		//get with mixin + props
		long mixinLastTime = ((MinecraftMixin)mc).lastTime;

		//get with jailbreak (breaks when remapped)
		long jailbreakLastTime = mc.jailbreak().lastTime = 10;
	}

	/**
	 * target: {@link PlacementInfo PlacementInfo}
	 */
	public void notMinecraft() {
		PlacementInfo info = new PlacementInfo(null);

		// get with mixin + props
		((PlacementInfoAccessor)info).end1Extent++;

		l.info("end2Extent: {}", ((PlacementInfoAccessor)info).end1Extent);

		// get with jailbreak (works but really mixin is better)
		info.jailbreak().end1Extent = 10;

		// mixin + ext
		info.setPos1(new BlockPos(0, 0, 0));
		BlockPos pos1 = info.getPos1();

		// mixin + props + ext
		info.pos1 = new BlockPos(0, 0, 0);
		BlockPos pos1_2 = info.pos1;
	}
}
