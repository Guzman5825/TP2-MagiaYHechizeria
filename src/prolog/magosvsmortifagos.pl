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




