<!--  ${minMapLong<0 ? (minMapLong*-1): minMapLong}&deg;${minMapLong>0?'E':'W'},
${minMapLat<0 ? (minMapLat*-1): minMapLat}&deg;${minMapLat>0?'N':'S'},
${maxMapLong<0 ? (maxMapLong*-1): maxMapLong}&deg;${minMapLong>0?'E':'W'},
${maxMapLat<0 ? (maxMapLat*-1): maxMapLat}&deg;${maxMapLat>0?'N':'S'} -->

Lon ${minMapLong>0?' ':'-'}${minMapLong<0 ? (minMapLong*-1): minMapLong},
Lat ${minMapLat>0?' ':'-'}${minMapLat<0 ? (minMapLat*-1): minMapLat},
Lon ${minMapLong>0?' ':'-'}${maxMapLong<0 ? (maxMapLong*-1): maxMapLong},
Lat ${maxMapLat>0?' ':'-'}${maxMapLat<0 ? (maxMapLat*-1): maxMapLat}
