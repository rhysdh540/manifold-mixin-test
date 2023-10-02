package dev.rdh.manifoldmixintest.extensions.com.simibubi.create.content.trains.track.TrackPlacement.PlacementInfo;

import dev.rdh.manifoldmixintest.mixin.PlacementInfoAccessor;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import net.minecraft.core.BlockPos;

import com.simibubi.create.content.trains.track.TrackPlacement.PlacementInfo;

@Extension
public class PlacementInfoExt {
	public static BlockPos getPos1(@This PlacementInfo info) {
		return ((PlacementInfoAccessor)info).getPos1();
	}
	public static void setPos1(@This PlacementInfo info, BlockPos newPos1) {
		((PlacementInfoAccessor)info).setPos1(newPos1);
	}
}