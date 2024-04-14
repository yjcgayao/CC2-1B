using System.Diagnostics;

namespace CC31BParkingMS
{
    enum VehicleSize
    {
        Motorcycle,
        Compact,
        Large
    }

    abstract class Vehicle
    {
        public VehicleSize Size { get; set; }
        public string LicensePlate { get; set; }

        public Vehicle(VehicleSize size, string licensePlate)
        {
            Size = size;
            LicensePlate = licensePlate;
        }
    }

    class Car: Vehicle
    {
        public Car(string licensePlate):
            base(VehicleSize.Compact, licensePlate)
        { }
    }
    class Truck: Vehicle
    {
        public Truck(string licensePlate):
            base(VehicleSize.Large, licensePlate)
        { }
    }
    class Motorcycle: Vehicle
    {
        public Motorcycle(string licensePlate):
            base (VehicleSize.Motorcycle, licensePlate)
        { }
    }
    
    class ParkingSpot
    {
        public Vehicle? ParkedVehicle;

        public bool IsAvailable()
        {
            return ParkedVehicle == null;
        }
        public bool CanFitVehicle(Vehicle vehicle)
        {
            return IsAvailable() && (vehicle.Size == VehicleSize.Motorcycle ||
               (vehicle.Size == VehicleSize.Compact || vehicle.Size == VehicleSize.Large));
        }

        public bool ParkVehicle(Vehicle vehicle)
        {
            if (!CanFitVehicle(vehicle))
            {
                return false;
            }
            ParkedVehicle = vehicle;
            return true;
        }
        public void RemoveVehicle()
        {
            ParkedVehicle = null;
        }
    }

    class Level
    {
        List<ParkingSpot> parkingSpots;
        public Level(int spots)
        {
            parkingSpots = new List<ParkingSpot>(spots);
            for(int i = 0; i < spots; i++)
            {
                parkingSpots.Add(new ParkingSpot());
            }
        }
        public bool HasAvailableSpot()
        {
            foreach(ParkingSpot spot in parkingSpots)
            {
                if (spot.IsAvailable())
                {
                    return true;
                }
            }
            return false;
        }
        public bool ParkVehicle(Vehicle vehicle)
        {
            foreach(ParkingSpot spot in parkingSpots)
            {
                if (spot.ParkVehicle(vehicle))
                {
                    return true;
                }
            }
            return false;
        }
        public bool RemoveVehicle(Vehicle vehicle)
        {
            foreach (ParkingSpot spot in parkingSpots)
            {
                if (spot.ParkedVehicle?.LicensePlate == vehicle.LicensePlate)
                {
                    spot.RemoveVehicle();
                    return true;
                }
            }
            return false;
        }
    }

    class ParkingLot
    {
        List<Level> levels;
        public ParkingLot(int numLevels, int numSpots)
        {
            levels = new List<Level>(numLevels);
            for(int i = 0; i < numLevels; i++)
            {
                levels.Add(new Level(numSpots));
            }
        }
        public bool ParkVehicle(Vehicle vehicle)
        {
            foreach(Level level in levels)
            {
                if (level.ParkVehicle(vehicle))
                {
                    return true;
                }
            }
            return false;
        }
        public bool RemoveVehicle(Vehicle vehicle)
        {
            foreach(Level level in levels)
            {
                if (level.RemoveVehicle(vehicle))
                {
                    return true;
                }
            }
            return false;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {

            int levels = 2;
            int spotsPerLevel = 10;
            ParkingLot parkingLot = new ParkingLot(levels, spotsPerLevel);

            Car car1 = new Car("ABC123");
            Car car2 = new Car("DEF456");
            Truck truck1 = new Truck("GHI789");
            Motorcycle bike1 = new Motorcycle("JKL012");

            Console.WriteLine("Park Car1: " + parkingLot.ParkVehicle(car1));
            Console.WriteLine("Park Car2: " + parkingLot.ParkVehicle(car2));
            Console.WriteLine("Park Truck1: " + parkingLot.ParkVehicle(truck1));
            Console.WriteLine("Park Bike1: " + parkingLot.ParkVehicle(bike1));

            Console.WriteLine("Remove Car1: " + parkingLot.RemoveVehicle(car1));
            Console.WriteLine("Remove Car2: " + parkingLot.RemoveVehicle(car2));
            Console.WriteLine("Remove Truck1: " + parkingLot.RemoveVehicle(truck1));
            Console.WriteLine("Remove Bike1: " + parkingLot.RemoveVehicle(bike1));
        }
    }
}
