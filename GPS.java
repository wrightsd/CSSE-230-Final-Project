import java.util.HashMap;

public class GPS {
	private HashMap<String, Location> locationList;

	/**
	 * Creates a HashMap of Locations, and instantiates all their connections.
	 */
	public GPS() {
		// Define the locations
		Location GreyHavens = new Location(36, 45, "GreyHavens (Mithlond)", 0);
		Location BlueMountains = new Location(35, 60, "Blue Mountains", 60);
		Location BagEnd = new Location(53, 44, "Bag End (Hobbiton)", 0);
		Location GreenDragonInn = new Location(55, 43, "Green Dragon Inn", 5);
		Location TomBombadilHouse = new Location(64, 46,
				"Tom Bombadil's House", 80);
		Location BrandywineBridge = new Location(58, 43, "Brandywine Bridge",
				10);
		Location MidgewaterMarshes = new Location(73, 43, "Midgewater Marshes",
				65);
		Location BarrowDowns = new Location(63, 50, "Barrow Downs", 378);
		Location Bree = new Location(68, 45, "Prancing Pony (Bree)", 25);
		Location Weathertop = new Location(79, 43, "Weathertop (Amon Sul)", 15);
		Location Trollshaws = new Location(97, 42, "Trollshaws", 15);
		Location Gundabad = new Location(105, 20, "Gundabad", 413);
		Location Rivendell = new Location(103, 43, "Rivendell (Imladris)", 0);
		Location Moria = new Location(100, 62, "Mines of Moria (Khazad-dum)",
				445);
		Location Caradhras = new Location(104, 60,
				"Pass of Caradhras (Redhorn)", 30, 415);
		Location HighPass = new Location(110, 40, "High Pass (Goblin Town)",
				150);
		Location Lothlorien = new Location(110, 68, "Lothlorien", 0);
		Location AmonHen = new Location(126, 95,
				"Amon Hen (The Seat Of Seeing)", 73);
		Location Argonath = new Location(126, 99, "Argonath", 15);
		Location FallsOfRauros = new Location(128, 100, "Falls of Rauros", 45);
		Location Isengard = new Location(93, 87, "Isengard (Orthanc)", 278);
		Location FordsOfIsen = new Location(93, 93, "Fords of Isen", 45);
		Location Fangorn = new Location(104, 85, "Fangorn", 55, 147);
		Location HelmsDeep = new Location(98, 98, "Helm's Deep", 10);
		Location DolGuldur = new Location(125, 66, "Dol Guldur (Amon Lanc)",
				615);
		Location WoodlandRealm = new Location(135, 30, "Woodland Realm", 278);
		Location Erebor = new Location(142, 28, "Erebor (The Lonely Mountain)",
				83);
		Location Esgaroth = new Location(143, 32, "Esgaroth (Lake Town)", 38);
		Location Dale = new Location(143, 29, "Dale", 29);
		Location IronHills = new Location(167, 28, "Iron Hills", 67);
		Location DeadMarshes = new Location(137, 98, "Dead Marshes", 543);
		Location BlackGate = new Location(145, 99, "Black Gate (Morannon)", 538);
		Location MountDoom = new Location(151, 108, "Mount Doom (Orodruin)",
				398);
		Location CirithUngol = new Location(144, 113,
				"Stairs of Cirith Ungol (Shelob's Lair)", 567);
		Location MinasMorgul = new Location(141, 113,
				"Minas Morgul (Minas Ithil)", 543);
		Location Baraddur = new Location(160, 105,
				"The Black Tower (Barad-dur)", 656);
		Location Harad = new Location(170, 158, "Harad", 436);
		Location MinasTirith = new Location(137, 113,
				"Minas Tirith (Minas Arnor)", 78);
		Location Osgiliath = new Location(138, 113, "Osgiliath", 432);
		Location Rhosgobel = new Location(127, 60, "Rhosgobel (Brownhay)", 0);
		Location Meduseld = new Location(105, 101,
				"Meduseld (The Golden Hall)", 64);
		Location Dunharrow = new Location(103, 103,
				"Entrance to the Paths of the Dead (Dunharrow)", 602);
		Location FieldOfCelebrant = new Location(118, 76, "Field of Celebrant",
				67);
		Location Fornost = new Location(65, 34, "Fornost (Deadman's Dike)", 47);
		Location Pelargir = new Location(132, 128, "Pelargir", 52);

		// Define the connections
		{
			GreyHavens.addConnection(new Path(Fornost, 270, 283));
			GreyHavens.addConnection(new Path(Rivendell, 580, 617));
			GreyHavens.addConnection(new Path(BagEnd, 165, 172));
			GreyHavens.addConnection(new Path(BlueMountains, 125, 137));
		}
		{
			BlueMountains.addConnection(new Path(GreyHavens, 125, 137));
			BlueMountains.addConnection(new Path(BagEnd, 230, 255));
			BlueMountains.addConnection(new Path(Bree, 320, 345));
		}
		{
			BagEnd.addConnection(new Path(GreyHavens, 165, 172));
			BagEnd.addConnection(new Path(BrandywineBridge, 50, 50));
			BagEnd.addConnection(new Path(TomBombadilHouse, 80, 115));
			BagEnd.addConnection(new Path(GreenDragonInn, 10, 10));
			BagEnd.addConnection(new Path(Rivendell, 430, 445));
			BagEnd.addConnection(new Path(BlueMountains, 230, 255));
		}
		{
			GreenDragonInn.addConnection(new Path(BagEnd, 10, 10));
			GreenDragonInn.addConnection(new Path(Trollshaws, 375, 395));
		}
		{
			TomBombadilHouse.addConnection(new Path(BagEnd, 80, 115));
			TomBombadilHouse.addConnection(new Path(BarrowDowns, 30, 35));
		}
		{
			BrandywineBridge.addConnection(new Path(BagEnd, 50, 50));
			BrandywineBridge.addConnection(new Path(Bree, 80, 85));
		}
		{
			MidgewaterMarshes.addConnection(new Path(Bree, 40, 47));
			MidgewaterMarshes.addConnection(new Path(Weathertop, 55, 62));
		}
		{
			BarrowDowns.addConnection(new Path(TomBombadilHouse, 30, 35));
			BarrowDowns.addConnection(new Path(Bree, 30, 35));
		}
		{
			Bree.addConnection(new Path(BarrowDowns, 30, 35));
			Bree.addConnection(new Path(BrandywineBridge, 80, 85));
			Bree.addConnection(new Path(MidgewaterMarshes, 40, 47));
			Bree.addConnection(new Path(Weathertop, 82, 87));
			Bree.addConnection(new Path(Isengard, 420, 467));
			Bree.addConnection(new Path(BlueMountains, 320, 345));
		}
		{
			Weathertop.addConnection(new Path(Bree, 82, 87));
			Weathertop.addConnection(new Path(Fornost, 150, 170));
			Weathertop.addConnection(new Path(MidgewaterMarshes, 55, 62));
			Weathertop.addConnection(new Path(Trollshaws, 155, 162));
		}
		{
			Trollshaws.addConnection(new Path(Weathertop, 155, 162));
			Trollshaws.addConnection(new Path(Rivendell, 50, 55));
			Trollshaws.addConnection(new Path(Gundabad, 200, 243));
		}
		{
			Gundabad.addConnection(new Path(Trollshaws, 200, 243));
			Gundabad.addConnection(new Path(Rivendell, 170, 213));
			Gundabad.addConnection(new Path(WoodlandRealm, 300, 362));
			Gundabad.addConnection(new Path(Erebor, 320, 371));
		}
		{
			Rivendell.addConnection(new Path(Trollshaws, 50, 55));
			Rivendell.addConnection(new Path(GreyHavens, 580, 617));
			Rivendell.addConnection(new Path(Gundabad, 170, 213));
			Rivendell.addConnection(new Path(HighPass, 60, 75));
			Rivendell.addConnection(new Path(DeadMarshes, 668, 700));
			Rivendell.addConnection(new Path(Rhosgobel, 227, 242));
			Rivendell.addConnection(new Path(Caradhras, 215, 230));
			Rivendell.addConnection(new Path(Moria, 207, 222));
			Rivendell.addConnection(new Path(BagEnd, 430, 445));
		}
		{
			Moria.addConnection(new Path(Rivendell, 207, 222));
			Moria.addConnection(new Path(Caradhras, 10, 30));
			Moria.addConnection(new Path(Lothlorien, 105, 125));
		}
		{
			Caradhras.addConnection(new Path(Rivendell, 215, 230));
			Caradhras.addConnection(new Path(Moria, 10, 30));
			Caradhras.addConnection(new Path(Lothlorien, 113, 133));
		}
		{
			HighPass.addConnection(new Path(Rivendell, 60, 75));
			HighPass.addConnection(new Path(WoodlandRealm, 385, 403));
			HighPass.addConnection(new Path(Esgaroth, 360, 378));
			HighPass.addConnection(new Path(DolGuldur, 270, 301));
		}
		{
			Lothlorien.addConnection(new Path(Caradhras, 113, 133));
			Lothlorien.addConnection(new Path(Rhosgobel, 185, 199));
			Lothlorien.addConnection(new Path(DolGuldur, 127, 143));
			Lothlorien.addConnection(new Path(Argonath, 285, 307));
			Lothlorien.addConnection(new Path(FieldOfCelebrant, 92, 103));
			Lothlorien.addConnection(new Path(Fangorn, 140, 157));
			Lothlorien.addConnection(new Path(Moria, 10, 30));
		}
		{
			AmonHen.addConnection(new Path(Argonath, 10, 15));
			AmonHen.addConnection(new Path(FallsOfRauros, 3, 7));
			AmonHen.addConnection(new Path(DeadMarshes, 80, 95));
			AmonHen.addConnection(new Path(MinasTirith, 157, 189));
		}
		{
			Argonath.addConnection(new Path(FieldOfCelebrant, 200, 231));
			Argonath.addConnection(new Path(Lothlorien, 285, 307));
			Argonath.addConnection(new Path(FallsOfRauros, 10, 15));
			Argonath.addConnection(new Path(AmonHen, 10, 15));
		}
		{
			FallsOfRauros.addConnection(new Path(Argonath, 10, 15));
			FallsOfRauros.addConnection(new Path(DeadMarshes, 78, 93));
			FallsOfRauros.addConnection(new Path(MinasTirith, 160, 192));
			FallsOfRauros.addConnection(new Path(AmonHen, 3, 7));
		}
		{
			Isengard.addConnection(new Path(Fangorn, 117, 149));
			Isengard.addConnection(new Path(FieldOfCelebrant, 243, 303));
			Isengard.addConnection(new Path(FordsOfIsen, 53, 90));
			Isengard.addConnection(new Path(Bree, 420, 467));
		}
		{
			FordsOfIsen.addConnection(new Path(Isengard, 53, 90));
			FordsOfIsen.addConnection(new Path(FieldOfCelebrant, 250, 290));
			FordsOfIsen.addConnection(new Path(HelmsDeep, 75, 120));
			FordsOfIsen.addConnection(new Path(Meduseld, 143, 198));
		}
		{
			Fangorn.addConnection(new Path(Lothlorien, 140, 157));
			Fangorn.addConnection(new Path(Isengard, 117, 149));
		}
		{
			HelmsDeep.addConnection(new Path(FordsOfIsen, 75, 120));
			HelmsDeep.addConnection(new Path(Meduseld, 50, 61));
			HelmsDeep.addConnection(new Path(Dunharrow, 45, 53));
		}
		{
			DolGuldur.addConnection(new Path(HighPass, 270, 301));
			DolGuldur.addConnection(new Path(Rhosgobel, 110, 145));
			DolGuldur.addConnection(new Path(Erebor, 360, 472));
			DolGuldur.addConnection(new Path(Esgaroth, 350, 462));
			DolGuldur.addConnection(new Path(Dale, 330, 451));
			DolGuldur.addConnection(new Path(BlackGate, 320, 357));
		}
		{
			WoodlandRealm.addConnection(new Path(Gundabad, 320, 371));
			WoodlandRealm.addConnection(new Path(HighPass, 385, 403));
			WoodlandRealm.addConnection(new Path(Erebor, 30, 40));
			WoodlandRealm.addConnection(new Path(Dale, 40, 51));
			WoodlandRealm.addConnection(new Path(Esgaroth, 28, 37));
		}
		{
			Erebor.addConnection(new Path(Gundabad, 320, 371));
			Erebor.addConnection(new Path(IronHills, 250, 271));
			Erebor.addConnection(new Path(Dale, 20, 28));
			Erebor.addConnection(new Path(Esgaroth, 30, 39));
			Erebor.addConnection(new Path(WoodlandRealm, 30, 40));
		}
		{
			Esgaroth.addConnection(new Path(WoodlandRealm, 28, 37));
			Esgaroth.addConnection(new Path(Erebor, 30, 39));
			Esgaroth.addConnection(new Path(Dale, 7, 12));
			Esgaroth.addConnection(new Path(DolGuldur, 350, 462));
			Esgaroth.addConnection(new Path(HighPass, 360, 378));
		}
		{
			Dale.addConnection(new Path(DolGuldur, 330, 451));
			Dale.addConnection(new Path(Esgaroth, 7, 12));
			Dale.addConnection(new Path(WoodlandRealm, 40, 51));
			Dale.addConnection(new Path(Erebor, 20, 28));
			Dale.addConnection(new Path(IronHills, 245, 265));
		}
		{
			IronHills.addConnection(new Path(Erebor, 250, 271));
			IronHills.addConnection(new Path(Dale, 245, 265));
			IronHills.addConnection(new Path(Esgaroth, 250, 271));
		}
		{
			DeadMarshes.addConnection(new Path(Rivendell, 668, 700));
			DeadMarshes.addConnection(new Path(FallsOfRauros, 78, 93));
			DeadMarshes.addConnection(new Path(AmonHen, 80, 95));
			DeadMarshes.addConnection(new Path(MinasTirith, 130, 153));
			DeadMarshes.addConnection(new Path(Osgiliath, 125, 155));
			DeadMarshes.addConnection(new Path(CirithUngol, 130, 165));
			DeadMarshes.addConnection(new Path(BlackGate, 80, 95));
		}
		{
			BlackGate.addConnection(new Path(DolGuldur, 320, 357));
			BlackGate.addConnection(new Path(Baraddur, 140, 192));
			BlackGate.addConnection(new Path(MountDoom, 106, 154));
			BlackGate.addConnection(new Path(MinasMorgul, 138, 189));
			BlackGate.addConnection(new Path(Osgiliath, 145, 172));
			BlackGate.addConnection(new Path(DeadMarshes, 80, 95));
		}
		{
			MountDoom.addConnection(new Path(BlackGate, 106, 154));
			MountDoom.addConnection(new Path(CirithUngol, 82, 127));
		}
		{
			CirithUngol.addConnection(new Path(MountDoom, 82, 127));
			CirithUngol.addConnection(new Path(MinasMorgul, 4, 9));
		}
		{
			MinasMorgul.addConnection(new Path(CirithUngol, 4, 9));
			MinasMorgul.addConnection(new Path(Pelargir, 152, 177));
			MinasMorgul.addConnection(new Path(Osgiliath, 33, 44));
			MinasMorgul.addConnection(new Path(DeadMarshes, 130, 165));
			MinasMorgul.addConnection(new Path(BlackGate, 138, 189));
		}
		{
			Baraddur.addConnection(new Path(BlackGate, 140, 192));
			Baraddur.addConnection(new Path(Harad, 346, 487));
		}
		{
			Harad.addConnection(new Path(Baraddur, 346, 487));
			Harad.addConnection(new Path(Pelargir, 156, 238));
		}
		{
			MinasTirith.addConnection(new Path(Dunharrow, 315, 405));
			MinasTirith.addConnection(new Path(Meduseld, 300, 320));
			MinasTirith.addConnection(new Path(AmonHen, 157, 189));
			MinasTirith.addConnection(new Path(FallsOfRauros, 160, 192));
			MinasTirith.addConnection(new Path(DeadMarshes, 130, 153));
			MinasTirith.addConnection(new Path(Osgiliath, 15, 25));
			MinasTirith.addConnection(new Path(Pelargir, 138, 160));
		}
		{
			Osgiliath.addConnection(new Path(Pelargir, 135, 156));
			Osgiliath.addConnection(new Path(MinasTirith, 15, 25));
			Osgiliath.addConnection(new Path(DeadMarshes, 125, 155));
			Osgiliath.addConnection(new Path(BlackGate, 145, 172));
			Osgiliath.addConnection(new Path(MinasMorgul, 33, 44));
		}
		{
			Rhosgobel.addConnection(new Path(Rivendell, 227, 242));
			Rhosgobel.addConnection(new Path(Lothlorien, 185, 199));
			Rhosgobel.addConnection(new Path(DolGuldur, 110, 145));
		}
		{
			Meduseld.addConnection(new Path(MinasTirith, 300, 320));
			Meduseld.addConnection(new Path(Dunharrow, 7, 7));
			Meduseld.addConnection(new Path(FordsOfIsen, 143, 198));
			Meduseld.addConnection(new Path(HelmsDeep, 50, 61));
		}
		{
			Dunharrow.addConnection(new Path(HelmsDeep, 45, 53));
			Dunharrow.addConnection(new Path(Meduseld, 7, 7));
			Dunharrow.addConnection(new Path(MinasTirith, 315, 405));
		}
		{
			FieldOfCelebrant.addConnection(new Path(Lothlorien, 92, 103));
			FieldOfCelebrant.addConnection(new Path(Isengard, 243, 303));
			FieldOfCelebrant.addConnection(new Path(FordsOfIsen, 250, 290));
			FieldOfCelebrant.addConnection(new Path(Argonath, 200, 231));
		}
		{
			Fornost.addConnection(new Path(GreyHavens, 270, 283));
			Fornost.addConnection(new Path(Weathertop, 150, 170));
		}
		{
			Pelargir.addConnection(new Path(Harad, 156, 238));
			Pelargir.addConnection(new Path(MinasMorgul, 152, 177));
			Pelargir.addConnection(new Path(Osgiliath, 135, 156));
			Pelargir.addConnection(new Path(MinasTirith, 138, 160));
		}
		this.locationList = new HashMap<String, Location>();

		// Adds the locations to the HashMap

		locationList.put("GreyHavens", GreyHavens);
		locationList.put("BlueMountains", BlueMountains);
		locationList.put("BagEnd", BagEnd);
		locationList.put("GreenDragonInn", GreenDragonInn);
		locationList.put("TomBombadilHouse", TomBombadilHouse);
		locationList.put("BrandywineBridge", BrandywineBridge);
		locationList.put("MidgewaterMarshes", MidgewaterMarshes);
		locationList.put("BarrowDowns", BarrowDowns);
		locationList.put("Bree", Bree);
		locationList.put("Weathertop", Weathertop);
		locationList.put("Trollshaws", Trollshaws);
		locationList.put("Gundabad", Gundabad);
		locationList.put("Rivendell", Rivendell);
		locationList.put("Moria", Moria);
		locationList.put("Caradhras", Caradhras);
		locationList.put("HighPass", HighPass);
		locationList.put("Lothlorien", Lothlorien);
		locationList.put("AmonHen", AmonHen);
		locationList.put("Argonath", Argonath);
		locationList.put("FallsOfRauros", FallsOfRauros);
		locationList.put("Isengard", Isengard);
		locationList.put("FordsOfIsen", FordsOfIsen);
		locationList.put("Fangorn", Fangorn);
		locationList.put("HelmsDeep", HelmsDeep);
		locationList.put("DolGuldur", DolGuldur);
		locationList.put("WoodlandRealm", WoodlandRealm);
		locationList.put("Erebor", Erebor);
		locationList.put("Esgaroth", Esgaroth);
		locationList.put("Dale", Dale);
		locationList.put("IronHills", IronHills);
		locationList.put("DeadMarshes", DeadMarshes);
		locationList.put("BlackGate", BlackGate);
		locationList.put("MountDoom", MountDoom);
		locationList.put("CirithUngol", CirithUngol);
		locationList.put("MinasMorgul", MinasMorgul);
		locationList.put("Baraddur", Baraddur);
		locationList.put("Harad", Harad);
		locationList.put("MinasTirith", MinasTirith);
		locationList.put("Osgiliath", Osgiliath);
		locationList.put("Rhosgobel", Rhosgobel);
		locationList.put("Meduseld", Meduseld);
		locationList.put("Dunharrow", Dunharrow);
		locationList.put("FieldOfCelebrant", FieldOfCelebrant);
		locationList.put("Fornost", Fornost);
		locationList.put("Pelargir", Pelargir);
	}

	/**
	 * Gets the input Location from the HashMap.
	 * 
	 * @param input
	 *            a String that is used to call a specific Location
	 * @return a Location that is wanted, or null if the given String is not in
	 *         the HashMap
	 */
	public Location getLocation(String input) {
		return (Location) this.locationList.get(input);
	}
}