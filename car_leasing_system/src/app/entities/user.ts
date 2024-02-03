export class User {
    username: string;
    name: string;
    email: string;
    license_number: string;
    password: string;
    token: string;

    constructor()
    {
        this.username = "";
        this.name = "";
        this.email = "";
        this.license_number = "";
        this.password = "";
        this.token = "";
    }
}