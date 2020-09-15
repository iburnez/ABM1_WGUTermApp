package com.wgu.termapp.Model;

public class Term {
    private long termID;
    private String termName;
    private String termStart;
    private String termEnd;
    private int termActive;
    private String termCreated;

    public Term(long termID, String termName, String termStart, String termEnd, int termActive){
        setTermsID(termID);
        setTermName(termName);
        setTermStart(termStart);
        setTermEnd(termEnd);
        setTermActive(termActive);

    }

    /**
     * _______________________________________________________________________
     *                                  SETTERS
     * -----------------------------------------------------------------------
     */

    public void setTermsID(long termID){
        this.termID = termID;
    }

    public void setTermName(String termName){
        this.termName = termName;
    }

    public void setTermStart(String termStart){
        this.termStart = termStart;
    }

    public void setTermEnd(String termEnd){
        this.termEnd = termEnd;
    }

    public void setTermActive(int termActive){
        this.termActive = termActive;
    }

    public void setTermCreated(String termCreated){
        this.termCreated = termCreated;
    }

    /**
     * _______________________________________________________________________
     *                                  GETTERS
     * -----------------------------------------------------------------------
     */

    public long getTermID(){
        return termID;
    }

    public String getTermName(){
        return termName;
    }

    public String getTermStart(){
        return termStart;
    }

    public String getTermEnd(){
        return termEnd;
    }

    public int getTermActive(){
        return termActive;
    }

    public String getTermCreated(){
        return termCreated;
    }


}
