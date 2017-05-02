package statistics.matcher;


public class QueryBuilder {
    
    Matcher m;
    
    public QueryBuilder() {
        m = new And();
    }
    
    public QueryBuilder playsIn(String team) {
        m = new And(m, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int count, String field) {
        m = new And(m, new HasAtLeast(count, field));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int count, String field) {
        m = new And(m, new HasFewerThan(count, field));
        return this;
    }
    
    public Matcher build() {
        Matcher ret = new And(m);
        m = new And();
        return ret;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        m = new Or(m1, m2);
        return this;
    }
}
