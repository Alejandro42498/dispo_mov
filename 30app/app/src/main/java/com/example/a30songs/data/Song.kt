package com.example.a30songs.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30songs.R

data class Cancion(
    @DrawableRes val imagenResId: Int,
    @StringRes val titulo: Int,
    @StringRes val artista: Int
)

val canciones = listOf(
    Cancion(R.drawable.sting, R.string.titulo_fragile, R.string.artista_sting),
    Cancion(R.drawable.sting, R.string.titulo_crimen, R.string.artista_cerati),
    Cancion(R.drawable.sting, R.string.titulo_let_it_be, R.string.artista_beatles),
    Cancion(R.drawable.sting, R.string.titulo_bohemian, R.string.artista_queen),
    Cancion(R.drawable.sting, R.string.titulo_un_siglo_sin_ti, R.string.artista_chayanne),
    Cancion(R.drawable.sting, R.string.titulo_antologia, R.string.artista_shakira),
    Cancion(R.drawable.sting, R.string.titulo_fuiste_tu, R.string.artista_arjona),
    Cancion(R.drawable.sting, R.string.titulo_do_i_wanna_know, R.string.artista_am),
    Cancion(R.drawable.sting, R.string.titulo_yellow, R.string.artista_coldplay),
    Cancion(R.drawable.sting, R.string.titulo_borderline, R.string.artista_tame_impala),
    Cancion(R.drawable.sting, R.string.titulo_again, R.string.artista_lenny),
    Cancion(R.drawable.sting, R.string.titulo_youll_be_in_my_heart, R.string.artista_phil),
    Cancion(R.drawable.sting, R.string.titulo_es_por_ti, R.string.artista_juanes),
    Cancion(R.drawable.sting, R.string.titulo_stronger, R.string.artista_kanye),
    Cancion(R.drawable.sting, R.string.titulo_thriller, R.string.artista_mj),
    Cancion(R.drawable.sting, R.string.titulo_easy_on_me, R.string.artista_adele),
    Cancion(R.drawable.sting, R.string.titulo_musica_ligera, R.string.artista_sodastereo),
    Cancion(R.drawable.sting, R.string.titulo_ojala, R.string.artista_silvio),
    Cancion(R.drawable.sting, R.string.titulo_smells_like, R.string.artista_nirvana),
    Cancion(R.drawable.sting, R.string.titulo_creep, R.string.artista_radiohead),
    Cancion(R.drawable.sting, R.string.titulo_with_or_without_you, R.string.artista_u2),
    Cancion(R.drawable.sting, R.string.titulo_mr_brightside, R.string.artista_killers),
    Cancion(R.drawable.sting, R.string.titulo_viento, R.string.artista_caifanes),
    Cancion(R.drawable.sting, R.string.titulo_mariposa_tecnica, R.string.artista_fito),
    Cancion(R.drawable.sting, R.string.titulo_frente_a_frente, R.string.artista_bunbury),
    Cancion(R.drawable.sting, R.string.titulo_wish_you_were_here, R.string.artista_pf),
    Cancion(R.drawable.sting, R.string.titulo_hentai, R.string.artista_rosalia),
    Cancion(R.drawable.sting, R.string.titulo_callaita, R.string.artista_bad),
    Cancion(R.drawable.sting, R.string.titulo_levitating, R.string.artista_dua),
    Cancion(R.drawable.sting, R.string.titulo_love_story, R.string.artista_taylor)
)