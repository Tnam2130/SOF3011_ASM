$('#Href').val() != '' 

? $('#poster').attr('src', 'https://img.youtube.com/vi/' +$('#Href').val() +'/sddefault.jpg') 

: $('#poster').attr('src', 'https://innovating.capital/wp-content/uploads/2021/05/placeholder-image-dark.jpg')

$('#Href').keyup(function() {
	if($('#Href').val() != ''){
		$('#poster').attr('src', 'https://img.youtube.com/vi/' +$('#Href').val() +'/sddefault.jpg')
	} else {
		$('#poster').attr('src', 'https://innovating.capital/wp-content/uploads/2021/05/placeholder-image-dark.jpg')
	}
})








