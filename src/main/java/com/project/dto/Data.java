package com.project.dto;


import com.project.model.Address;
import com.project.model.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Data {

    private List<Result> results;

    private Info info;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString(){
        return "[results="+results+",info="+info+"]";
    }

    public UserDetails toUserEntity(){
        UserDetails entity = new UserDetails();

        entity.setFullName(this.getResults().get(0).getName().getFirst() + " " +
                this.getResults().get(0).getName().getLast());
        entity.setGender(this.getResults().get(0).getGender());
        entity.setEmail(this.getResults().get(0).getEmail());
        entity.setUserName(this.getResults().get(0).getEmail());
        entity.setPassword(this.getResults().get(0).getLogin().getPassword());
        entity.setDob(this.getResults().get(0).getDob().getDate());

        return entity;
    }

    public Address toAddressEntity(){
        Address entity = new Address();

        entity.setStreet(this.getResults().get(0).getLocation().getStreet().getName() + " " +
                this.getResults().get(0).getLocation().getStreet().getNumber());
        entity.setCountry(this.getResults().get(0).getLocation().getCountry());
        entity.setCity(this.getResults().get(0).getLocation().getCity());
        entity.setState(this.getResults().get(0).getLocation().getState());
        entity.setPostCode(this.getResults().get(0).getLocation().getPostcode());

        return entity;
    }

}
