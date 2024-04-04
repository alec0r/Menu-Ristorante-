<?php 

$host = "localhost";
$user = "root";
$password ="";
$db = "ristorante";

$conn = new mysqli($host,$user,$password,$db);

	$categoria=$_GET["categoria"];
	$xml = new SimpleXMLElement('<piatti/>');
	$stmt = $conn->query("SELECT P.ID_Piatto,P.nome,P.descrizione,P.prezzo FROM piatti as p inner join categorie as c on p.FK_Categoria=c.ID_Categoria WHERE c.nome='$categoria';");
	while($row = $stmt->fetch_assoc())
	{
		$user = $xml->addChild('piatto');
		foreach ($row as $key => $value) 
		{
			$user->addChild($key, $value);
		}
	}
	echo $xml->asXML();
	$xml->asXML("menu.xml");


?>
