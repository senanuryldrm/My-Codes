SELECT
PersonType,
COUNT(*) AS PersonCount
FROM Person.Person
GROUP BY PersonType

SELECT
Color,
COUNT(*) AS ProductCount
FROM Production.Product
WHERE Color IN ('Red', 'Black')
GROUP BY ColorSELECT
TerritoryID,
COUNT(*) AS SalesCount
FROM Sales.SalesOrderHeader
WHERE OrderDate BETWEEN '7/1/2005' AND '12/31/2006'
GROUP BY TerritoryID

SELECT
ST.Name AS TerritoryName,
COUNT(*) AS SalesCount
FROM Sales.SalesOrderHeader SOH
LEFT OUTER JOIN Sales.SalesTerritory ST
ON ST.TerritoryID = SOH.TerritoryID
WHERE OrderDate BETWEEN '7/1/2005' AND '12/31/2006'
GROUP BY ST.Name

SELECT
A.AuthorName,
COUNT(*) AS BookCount
FROM BookAuthor BA
INNER JOIN Author A
ON A.AuthorID = BA.AuthorID
GROUP BY A.AuthorName

SELECT COUNT(*)
FROM Person.PersonSELECT COUNT(MiddleName)
FROM Person.Person

SELECT AVG(StandardCost)
FROM Production.Product
WHERE StandardCost > 0

SELECT AVG(Freight)
FROM Sales.SalesOrderHeader
WHERE TerritoryID = 4

SELECT MAX(ListPrice)
FROM Production.Product

SELECT SUM(P.ListPrice*I.Quantity)
FROM Production.Product P
INNER JOIN Production.ProductInventory I
ON I.ProductID = P.ProductID
WHERE P.ListPrice > 0

SELECT
FirstName,
LastName,
JobTitle
FROM HumanResources.vEmployeeDepartment
ORDER BY FirstName ASC

SELECT
FirstName,
LastName,
JobTitle
FROM HumanResources.vEmployeeDepartment
ORDER BY FirstName, LastName DESC

SELECT
FirstName,
LastName,
CountryRegionName
FROM Sales.vIndividualCustomer
ORDER BY 3

SELECT
FirstName,
LastName,
CountryRegionName
FROM Sales.vIndividualCustomer
WHERE CountryRegionName IN ('United	States', 'France')
ORDER BY CountryRegionName

SELECT
Name,
AnnualSales,
YearOpened,
SquareFeet AS [Store	Size],
NumberEmployees AS [Total	Employees]
FROM Sales.vStoreWithDemographics
WHERE AnnualSales > 1000000
AND NumberEmployees >= 45
ORDER BY [Store	Size] DESC, [Total	Employees] DESC

SELECT FirstName, LastName
FROM Person.Person
WHERE FirstName = 'Mark'SELECT TOP 100	*
FROM Production.Product
WHERE ListPrice <> 0.00

SELECT *
FROM HumanResources.vEmployee
WHERE LastName < 'D'SELECT *
FROM Person.StateProvince
WHERE CountryRegionCode = 'CA'SELECT
FirstName AS "Customer	First	Name",
LastName AS "Customer	Last	Name"
FROM Sales.vIndividualCustomer
WHERE LastName = 'Smith'

SELECT *
FROM Sales.vIndividualCustomer
WHERE CountryRegionName = 'Australia' OR
(PhoneNumberType = 'Cell' AND EmailPromotion = 0)

SELECT *
FROM HumanResources.vEmployeeDepartment
WHERE Department IN ('Executive', 'Tool	Design', 'Engineering')

SELECT *
FROM HumanResources.vEmployeeDepartment
WHERE Department = 'Executive' OR Department = 'Tool	Design'
OR Department = 'Engineering'

SELECT *
FROM HumanResources.vEmployeeDepartment
WHERE StartDate BETWEEN '7/1/2000' AND '6/30/2002'
SELECT *
FROM HumanResources.vEmployeeDepartment
WHERE StartDate >= '7/1/2000' AND StartDate <= '6/30/2002'

SELECT *
FROM Sales.vIndividualCustomer
WHERE LastName LIKE 'R%'SELECT *
FROM Sales.vIndividualCustomer
WHERE LastName IN ('Lopez', 'Martin', 'Wood') AND
FirstName LIKE '[C-L]%'

SELECT
SalesPersonID,
TotalDue
FROM Sales.SalesOrderHeader
WHERE SalesPersonID IS NOT NULL
AND TotalDue > 70000