% hechizos(TODO EN MINUSCULA) y sus costes de mana
%lo unico malo de tener los hechizos aca es que si ocurre algun cambio con algun hechizo tenemos que tener dos archivos sincronizados
%el cambio debe verse reflejado ac� en Prolog y en Java para evitar errores.
hechizo(avadakedavra, 80).
hechizo(veneficus,40).
hechizo(protego,40).
hechizo(petrificus,50).
hechizo(septusembra,30).
hechizo(bombardum,90).
hechizo(incendium,40).

%puede_lanzar/2: indica si un personaje puede castear x hechizo
%nombre hechizo (TODO EN MINUSCULA), nivel actual de mana del personaje que quiere lanzar x hechizo
puede_lanzar(Hechizo, ManaPersonaje) :-
    hechizo(Hechizo, CosteMana),
    ManaPersonaje >= CosteMana.

%lista_hechizos_lanzables/3: en basa al mana del personaje, devuelve una lista con los hechizos lanzables
lista_hechizos_lanzables(ManaPersonaje, Hechizos) :-
	findall(Hechizo, puede_lanzar(Hechizo, ManaPersonaje), Hechizos).

% personaje_derrotable/3: Dado un ataque y una lista de enemigos, devuelve los enemigos derrotables.
personaje_derrotable(AtaquePersonaje, ListaEnemigos, EnemigosDerrotables) :-
    findall(NombreEnemigo, (
        member((NombreEnemigo, VidaActual), ListaEnemigos),
        AtaquePersonaje >= VidaActual
    ), EnemigosDerrotables).


