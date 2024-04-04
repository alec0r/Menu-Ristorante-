<?php 

$host = "localhost";
$user = "root";
$password ="";
$db = "ristorante";

$conn = new mysqli($host,$user,$password,$db);

 $valore=$_GET['nomePiatto'];
 
	
 $xml = new SimpleXMLElement('<informazioni/>');
 $stmt = $conn->query("select distinct a.nome from piatti as p inner join piatti_allergeni as pa on p.ID_Piatto=pa.FK_Piatto inner join allergeni as a on pa.FK_Allergene=a.ID_Allergene
 where p.nome='$valore';");
 while($row = $stmt->fetch_assoc())
 {
 	$user = $xml->addChild('allergene');
    foreach ($row as $key => $value) 
 	{
 		$user->addChild($key, $value);
     }
 }
	echo $xml->asXML();
	 $xml->asXML("allergeni.xml");




?>