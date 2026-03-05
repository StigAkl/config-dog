import { createFileRoute } from "@tanstack/react-router";
import { Flag } from "lucide-react";
import { useState } from "react";

export const Route = createFileRoute("/")({ component: App });

type Environment = "Development" | "Staging" | "Production";

type FeatureFlag = Record<string, boolean>;

const featureFlags: FeatureFlag = {
	fastCheckout: false,
	newView: true,
};

function App() {
	const [features, setFeatures] = useState(featureFlags);

	const keys = Object.keys(features);
	return (
		<main className="page-wrap px-4 pb-8 pt-14">
			<div className="flex items-center justify-center gap-2 text-xl">
				<div className="p-2 bg-(--color-lagoon-deep) rounded-lg">
					<Flag className="text-white" />
				</div>
				<div className="flex flex-col">
					<h1>Feature Toggles</h1>
					<span className="text-sm">Production</span>
				</div>
			</div>

			<section className="min-w-full mt-5">
				<div className="flex flex-col gap-2 w-full">
					{keys.map((key) => (
						<label
							key={key}
							className="flex w-full cursor-pointer items-center gap-4 bg-(--hero-a) p-4 rounded-lg"
						>
							<span className="relative inline-flex h-6 w-11 shrink-0 items-center">
								<input
									type="checkbox"
									className="peer sr-only"
									checked={features[key]}
									onChange={() =>
										setFeatures((prev) => ({
											...prev,
											[key]: !prev[key],
										}))
									}
								/>
								<span className="h-6 w-11 rounded-full bg-gray-300 transition peer-checked:bg-blue-500" />
								<span className="absolute left-0.5 top-0.5 h-5 w-5 rounded-full bg-white transition-transform peer-checked:translate-x-5" />
							</span>

							<span className="select-none">{key}</span>
						</label>
					))}
				</div>
			</section>
			<div className="p-10">
				<label htmlFor="input">Hei feature toggles</label>
				<input type="text" name="input" placeholder="test" />
			</div>
		</main>
	);
}
