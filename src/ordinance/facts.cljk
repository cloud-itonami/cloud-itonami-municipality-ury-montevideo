(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Montevideo (Intendencia
  de Montevideo, Uruguay) -- the TWENTY-FIRST municipality-level entry
  (see cloud-itonami-municipality-jpn-tokyo, -usa-washington-dc,
  -gbr-london, -can-toronto, -deu-berlin, -fra-paris, -nld-amsterdam,
  -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney, -arg-buenos-aires,
  -fin-helsinki, -dnk-copenhagen, -nor-oslo, -bel-brussels,
  -chl-santiago, -col-bogota, -cri-san-jose, -bra-sao-paulo for the
  first twenty) per ADR-2607141700 (cloud-itonami-compliance-fact-federation).

  Every entry cites an OFFICIAL normativa.montevideo.gub.uy (the
  Intendencia de Montevideo's own 'Normativa Departamental' repository)
  URL -- never fabricated. An ordinance not in this table has NO
  spec-basis, full stop; extend `catalog`, do not invent an
  id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"montevideo"
   [{:ordinance/id "montevideo.resolucion-326-13-terminologia-departamental"
     :ordinance/title "Resolución IM N.º 326/13 (cambio de terminología de 'Municipal' a 'Departamental')"
     :ordinance/municipality "montevideo"
     :ordinance/country "URY"
     :ordinance/kind :ordinance
     :ordinance/number "Res. IM N.º 326/13"
     :ordinance/url "https://normativa.montevideo.gub.uy/"
     :ordinance/url-provenance :official-normativa-montevideo-gub-uy
     :ordinance/enacted-date "2013-01-21"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:governance}}
    {:ordinance/id "montevideo.decreto-34353-ruina-riesgo-edificacion"
     :ordinance/title "Determinación de la Ruina y del Grado de Riesgo de la Edificación (Dto. JDM 34.353)"
     :ordinance/municipality "montevideo"
     :ordinance/country "URY"
     :ordinance/kind :ordinance
     :ordinance/number "D.4504 (Dto. JDM 34.353)"
     :ordinance/url "https://normativa.montevideo.gub.uy/content/d4504"
     :ordinance/url-provenance :official-normativa-montevideo-gub-uy
     :ordinance/enacted-date "2012-10-01"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:building-safety :public-safety}}]})

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
      :note (str "cloud-itonami-municipality-ury-montevideo Wave 0 (ADR-2607141700): "
                 (count (get catalog "montevideo")) " Montevideo entries seeded "
                 "with an official normativa.montevideo.gub.uy citation. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
