package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        // seuraavassa osoitteessa 27.11.2019 päivitetyt tilastot
        String url = "https://nhl27112019.herokuapp.com/players.txt";
        // ajan tasalla olevat tilastot osoitteessa
        // "https://nhlstatisticsforohtu.herokuapp.com/players.txt"

        Statistics stats = new Statistics(new PlayerReaderImpl(url));
          
//        Matcher m = new And( new HasAtLeast(5, "goals"),
//                             new HasAtLeast(5, "assists"),
//                             new PlaysIn("PHI")
//        );
        
//        Matcher m = new And(
//                new HasFewerThan(1, "goals"),
//                new PlaysIn("NYR")
//        );


//        Matcher m = new Or(
//                new And(
//                        new PlaysIn("PHI"),
//                        new HasAtLeast(10, "assists"),
//                        new HasFewerThan(8, "goals")), 
//                new And(
//                        new PlaysIn("EDM"),
//                        new HasAtLeast(20, "points")
//                ));

//        Matcher m = new And(
//                new HasAtLeast(20, "points"),
//                new Or(
//                        new PlaysIn("NYR"),
//                        new PlaysIn("NYI"),
//                        new PlaysIn("NJD")
//                )
//        );       
        
        QueryBuilder query = new QueryBuilder();
//        Matcher m2 = query.playsIn("NYR")
//                     .hasAtLeast(5, "goals")
//                     .hasFewerThan(10, "goals").build();

        Matcher m2 = query.oneOf(
                query.playsIn("EDM")
                        .hasAtLeast(20, "points").build(),
                query.playsIn("PHI")
                        .hasAtLeast(10, "assists")
                        .hasFewerThan(8, "goals").build()
                
        ).build();








//        for (Player player : stats.matches(m)) {
//            System.out.println(player);
//        }
        for (Player player : stats.matches(m2)) {
            System.out.println(player);
        }
    }
}
