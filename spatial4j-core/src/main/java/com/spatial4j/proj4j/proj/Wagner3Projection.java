/*
Copyright 2006 Jerry Huxtable

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

/*
 * This file was semi-automatically converted from the public-domain USGS PROJ source.
 */
package com.spatial4j.proj4j.proj;

import com.spatial4j.proj4j.ProjCoordinate;

public class Wagner3Projection extends PseudoCylindricalProjection {
	
	private final static double TWOTHIRD = 0.6666666666666666666667;

	private double C_x;

	@Override
  public ProjCoordinate project(double lplam, double lpphi, ProjCoordinate xy) {
		xy.x = C_x * lplam * Math.cos(TWOTHIRD * lpphi);
		xy.y = lpphi;
		return xy;
	}

	@Override
  public ProjCoordinate projectInverse(double x, double y, ProjCoordinate lp) {
		lp.y = y;
		lp.x = x / (C_x * Math.cos(TWOTHIRD * lp.y));
		return lp;
	}

	@Override
  public void initialize() {
		super.initialize();
		C_x = Math.cos(trueScaleLatitude) / Math.cos(2.*trueScaleLatitude/3.);
		es = 0.;
	}

	@Override
  public boolean hasInverse() {
		return true;
	}

	@Override
  public String toString() {
		return "Wagner III";
	}

}