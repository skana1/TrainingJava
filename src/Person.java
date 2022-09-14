public class Person {

    String _name;
    String _surname;
    String _city;
    String _address;

    public Person(String _name, String _surname, String _city, String _address) {
        this._name = _name;
        this._surname = _surname;
        this._city = _city;
        this._address = _address;
    }


    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_surname() {
        return _surname;
    }

    public void set_surname(String _surname) {
        this._surname = _surname;
    }

    public String get_city() {
        return _city;
    }

    public void set_city(String _city) {
        this._city = _city;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }
    @Override
    public String toString() {
        return "Person{" +
                "_name='" + _name + '\'' +
                ", _surname='" + _surname + '\'' +
                ", _city='" + _city + '\'' +
                ", _address='" + _address + '\'' +
                '}';
    }
}
