package com.example.guig_number.mechanics;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Party> partyList=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Party> getPartyList() {
        return partyList;
    }


    public void addParty(Party party){
        this.partyList.add(party);
    }
}
