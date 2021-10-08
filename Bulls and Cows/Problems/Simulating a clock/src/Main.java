class Clock {

    int hours = 12;
    int minutes = 0;

    void next() {
        if (this.minutes == 59) {
            this.minutes = 0;
            this.hours = this.hours == 12 ? 1 : this.hours + 1;
        } else {
            this.minutes++;
        }
    }
}