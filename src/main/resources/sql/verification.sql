-- Get all dealerships
SELECT * FROM dealerships;

-- Find all vehicles for a specific dealership
SELECT * FROM vehicles
LEFT JOIN inventory ON inventory.vehicle_id = vehicles.vehicle_id
WHERE inventory.dealership_id = 2;

-- Find a car by VIN
SELECT * FROM vehicles
WHERE vin = '7351010';

-- Find the dealership where a certain car is located, by VIN
SELECT * FROM dealerships
LEFT JOIN inventory ON inventory.dealership_id = dealerships.dealership_id
LEFT JOIN vehicles ON vehicles.vehicle_id = inventory.vehicle_id
WHERE vehicles.vin = '7351010';

-- Find all dealerships that have a certain car type
SELECT DISTINCT name, address, phone FROM dealerships
LEFT JOIN inventory ON inventory.dealership_id = dealerships.dealership_id
LEFT JOIN vehicles ON vehicles.vehicle_id = inventory.vehicle_id
WHERE vehicles.make = 'Toyota';

-- Get all sales information for a specific dealer for a specific date range
SELECT * from sales_contracts
LEFT JOIN inventory ON inventory.vehicle_id = sales_contracts.vehicle_id
LEFT JOIN dealerships ON dealerships.dealership_id = inventory.dealership_id
WHERE dealerships.dealership_id = 1 AND sales_contracts.sale_date BETWEEN '2023-04-01' AND '2023-04-05';
