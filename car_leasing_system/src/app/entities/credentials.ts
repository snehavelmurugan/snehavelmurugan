export class Credentials
{
    username: string;
    password: string;

    constructor()
    {
        this.username = "";
        this.password = "";
    }

    getUsername()
    {
        return this.username;
    }

    setUsername(username: string)
    {
        this.username = username;
    }

    getPassword()
    {
        return this.password;
    }

    setPassword(password: string)
    {
        this.password = password;
    }
}