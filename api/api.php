<?php 

$host = "localhost";
$user = "root";
$password ="";
$db = "ristorante";

$conn = new mysqli($host,$user,$password,$db);

 $valore=$_GET['nomePiatto'];

	 
	 $xml = new SimpleXMLElement('<informazioni/>');
	 $stmt = $conn->query("select i.nome, pi.quantita from piatti as p inner join piatti_ingredienti as pi on p.ID_Piatto=pi.FK_piatto inner join ingredienti as i on pi.FK_Ingrediente=i.ID_Ingrediente where 
	 p.nome='$valore';");
	 while($row = $stmt->fetch_assoc())
	 {
		$user = $xml->addChild('ingrediente');
		 foreach ($row as $key => $value) 
		{
			$user->addChild($key, $value);
		 }
	 }
	 $idpiatto = null;
	 echo $xml->asXML();
	 $xml->asXML("informazioni.xml");
	
?>















