export class Operator {
    name: String;
    surname: String;
    email: String;
    lastLoggedAt: Date;

    constructor({email, name, surname, lastLoggedAt}: Operator) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.lastLoggedAt = lastLoggedAt;
    }

}