/*
 *  Test for the Geometry Class
 *  Copyright (C) <year>  <name of author>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package uk.ac.ed.inf.mois.karr

import org.scalatest.{FlatSpec, Matchers}
import org.scalactic.TolerantNumerics

import uk.ac.ed.inf.mois.karr.Geometry

class GeometryTest extends FlatSpec with Matchers {
  "geometry" should "calculate volume" in {

    // Use approximate equality in `should equal`
    val precision = 1e-4
    implicit val doubleEquality =
      TolerantNumerics.tolerantDoubleEquality(precision)

    class Proc extends Geometry {
      val name = "GeometryTest"
      def step(t: Double, tau: Double) {}
    }
      
    val p = new Proc
    import p._

    m := 1.0
    rho := 2.0

    p(0,0)

    V.value should equal (0.5)
  }
}
