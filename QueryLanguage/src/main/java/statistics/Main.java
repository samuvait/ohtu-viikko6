package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
        
        QueryBuilder query = new QueryBuilder();
        Matcher m1 = query.playsIn("PHI")
                         .hasAtLeast(10, "goals")
                         .hasFewerThan(20, "assists").build();

        Matcher m2 = query.playsIn("EDM")
                          .hasAtLeast(60, "points").build();

        Matcher m = query.oneOf(m1, m2).build();
//        Matcher m = query.playsIn("NYR")
//                         .hasAtLeast(10, "goals")
//                         .hasFewerThan(25, "assists").build();
//
//        for (Player player : stats.matches(m)) {
//            System.out.println( player );
//        }
//        Matcher m = new Or( new And(new HasFewerThan(5, "goals"),
//                             new HasAtLeast(21, "assists")),
//                             new PlaysIn("PHI")
//        );
//        
        for (Player player : stats.matches(m)) {
            System.out.println( player );
        }
    }
}
