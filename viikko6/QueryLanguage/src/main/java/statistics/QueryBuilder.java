/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import java.util.ArrayList;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author khlehto
 */
class QueryBuilder {

    private Matcher matcher;
    
    public QueryBuilder() {
        this.matcher = new All();
    }
    
    public Matcher build() {
        Matcher mCopy = this.matcher; 
        this.matcher = new All();
        return mCopy;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(this.matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int i, String goals) {
        this.matcher = new And(this.matcher, new HasAtLeast(i, goals));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int i, String goals) {
        this.matcher = new And(this.matcher, new HasFewerThan(i, goals));
        return this;
    }

    public QueryBuilder oneOf(Matcher ma1, Matcher ma2) {
        this.matcher = new Or(ma1, ma2);
        return this;
    }
    
}
