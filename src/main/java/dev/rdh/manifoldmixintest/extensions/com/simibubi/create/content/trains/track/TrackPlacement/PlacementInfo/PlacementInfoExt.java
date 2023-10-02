package manifoldmixintest.extensions.com.simibubi.create.content.trains.track.TrackPlacement.PlacementInfo;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import com.simibubi.create.content.trains.track.TrackPlacement.PlacementInfo;

@Extension
public class PlacementInfoExt {
  public static void helloWorld(@This PlacementInfo thiz) {
    System.out.println("hello world!");
  }
}