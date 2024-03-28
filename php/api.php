<?php 

$host = "localhost";
$user = "root";
$password ="";
$db = "ristorante";

$conn = new mysqli($host,$user,$password,$db);

$xml = new SimpleXMLElement('<piatti/>');
$stmt = $conn->query("SELECT P.ID_Piatto,P.nome,P.descrizione,P.prezzo,C.nome as categoria FROM piatti as p inner join categorie as c on p.FK_Categoria=c.ID_Categoria;");
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

// // // recupero informazioni di uno specifico piatto
// $xml = new SimpleXMLElement('<informazioni/>');
// $stmt = $conn->query("select i.nome, pi.quantita from piatti as p inner join piatti_ingredienti as pi on p.ID_Piatto=pi.FK_piatto inner join ingredienti as i on pi.FK_Ingrediente=i.ID_Ingrediente where 
// p.ID_Piatto=2;");
// while($row = $stmt->fetch_assoc())
// {
// 	$user = $xml->addChild('ingrediente');
//     foreach ($row as $key => $value) 
// 	{
// 		$user->addChild($key, $value);
//     }
// }
// $stmt = $conn->query("select distinct a.nome from piatti as p inner join piatti_allergeni as pa on p.ID_Piatto=pa.FK_Piatto inner join allergeni as a on pa.FK_Allergene=a.ID_Allergene
// where p.ID_Piatto=2;");
// while($row = $stmt->fetch_assoc())
// {
// 	$user = $xml->addChild('allergene');
//     foreach ($row as $key => $value) 
// 	{
// 		$user->addChild($key, $value);
//     }
// }
// echo $xml->asXML();
// $xml->asXML("informazioni.xml");
?>