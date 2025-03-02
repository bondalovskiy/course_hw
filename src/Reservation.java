class Reservation {
    int reservationId;
    String customerName;
    String date;
    String startTime;
    String endTime;
    Workspace workspace;

    public Reservation(int reservationId, String customerName, String date, String startTime, String endTime, Workspace workspace) {
        this.reservationId = reservationId;
        this.customerName = customerName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workspace = workspace;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", Customer: " + customerName + ", Date: " + date + ", Time: " + startTime + " - " + endTime + ", Workspace: " + workspace.name;
    }
}