interface cred{
    "name":string,
    "age":number
}

interface contact{
    "phone":string,
    "email":string
}

export class User{
    public credentials:cred;
    public contactInfo:contact;
    constructor(credentials:cred,contactInfo:contact){
        this.credentials=credentials;
        this.contactInfo=contactInfo;
    }
}