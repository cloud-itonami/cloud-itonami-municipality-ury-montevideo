(ns culture.facts
  "Regional-culture catalog for Montevideo -- local dishes, protected
  products, beverages, festivals and heritage sites, piggybacked onto
  this municipality compliance repo per ADR-2607171400
  (cloud-itonami-municipality-culture-catalog, in com-junkawasaki/root),
  sibling namespace to `ordinance.facts` (ADR-2607141700).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "municipality-slug -> vector of culture entries."
  {"montevideo"
   [{:culture/id "montevideo.dish.chivito"
     :culture/name "Chivito"
     :culture/municipality "montevideo"
     :culture/country "URY"
     :culture/kind :dish
     :culture/summary "Uruguay's national dish, a beef sandwich that originated in 1946 at El Mejillón Bar in Punta del Este."
     :culture/url "https://en.wikipedia.org/wiki/Chivito_(sandwich)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "montevideo.dish.asado"
     :culture/name "Asado"
     :culture/municipality "montevideo"
     :culture/country "URY"
     :culture/kind :dish
     :culture/summary "Barbecue technique and social event traditional in Argentina and Uruguay."
     :culture/url "https://en.wikipedia.org/wiki/Asado"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "montevideo.dish.torta-frita"
     :culture/name "Torta frita"
     :culture/municipality "montevideo"
     :culture/country "URY"
     :culture/kind :dish
     :culture/summary "Fried dough cake; in Uruguay the local variant of the sopaipilla is known as torta frita."
     :culture/url "https://en.wikipedia.org/wiki/Torta_frita"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "montevideo.beverage.mate"
     :culture/name "Mate"
     :culture/municipality "montevideo"
     :culture/country "URY"
     :culture/kind :beverage
     :culture/summary "National beverage of Argentina, Paraguay and Uruguay; Uruguay is the largest per-capita consumer at around 19 litres per person per year."
     :culture/url "https://en.wikipedia.org/wiki/Mate_(drink)"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "montevideo.beverage.medio-y-medio"
     :culture/name "Medio y medio"
     :culture/municipality "montevideo"
     :culture/country "URY"
     :culture/kind :beverage
     :culture/summary "Blend of sweet sparkling wine and dry white wine, traditionally produced by the Roldós restaurant in Montevideo's Mercado del Puerto, open since 1888."
     :culture/url "https://es.wikipedia.org/wiki/Medio_y_medio"
     :culture/url-provenance :wikipedia-es
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "montevideo.product.tannat"
     :culture/name "Tannat"
     :culture/municipality "montevideo"
     :culture/country "URY"
     :culture/kind :product
     :culture/summary "Red-wine grape now among the most prominent in Uruguay, where it is considered the national grape."
     :culture/url "https://en.wikipedia.org/wiki/Tannat"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "montevideo.festival.uruguayan-carnival"
     :culture/name "Uruguayan Carnival"
     :culture/municipality "montevideo"
     :culture/country "URY"
     :culture/kind :festival
     :culture/summary "Annual festival from mid-January to late February, considered the longest carnival in the world, held primarily in Montevideo with the Desfile Inaugural and Desfile de Llamadas parades."
     :culture/url "https://en.wikipedia.org/wiki/Uruguayan_Carnival"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "montevideo.heritage.candombe"
     :culture/name "Candombe"
     :culture/municipality "montevideo"
     :culture/country "URY"
     :culture/kind :heritage
     :culture/summary "Style of music and dance that originated in Uruguay, rooted in Montevideo's Afro-descendant communities and carnival; inscribed by UNESCO on the Representative List of the Intangible Cultural Heritage of Humanity in 2009."
     :culture/url "https://en.wikipedia.org/wiki/Candombe"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "montevideo.heritage.ciudad-vieja"
     :culture/name "Ciudad Vieja"
     :culture/municipality "montevideo"
     :culture/country "URY"
     :culture/kind :heritage
     :culture/summary "Historic neighbourhood of Montevideo, founded in 1724 as a walled city and one of Uruguay's main tourist attractions."
     :culture/url "https://en.wikipedia.org/wiki/Ciudad_Vieja,_Montevideo"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "montevideo.heritage.palacio-salvo"
     :culture/name "Palacio Salvo"
     :culture/municipality "montevideo"
     :culture/country "URY"
     :culture/kind :heritage
     :culture/summary "Eclectic skyscraper at the intersection of 18 de Julio Avenue and Plaza Independencia in Montevideo, completed in 1928 and a major landmark."
     :culture/url "https://en.wikipedia.org/wiki/Palacio_Salvo"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-ury-montevideo culture catalog "
                 "(ADR-2607171400): " (count (get catalog "montevideo"))
                 " Montevideo entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [muni kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis muni)))
